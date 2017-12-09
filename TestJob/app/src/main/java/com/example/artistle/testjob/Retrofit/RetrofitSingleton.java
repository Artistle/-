package com.example.artistle.testjob.Retrofit;

import com.example.artistle.testjob.Api.UmorilApi;
import com.example.artistle.testjob.Model.PostModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;
import rx.subjects.BehaviorSubject;

/**
 * Created by artistle on 17.11.17.
 */

public class RetrofitSingleton {
    private static final String TAG = RetrofitSingleton.class.getSimpleName();
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    private static Observable<ArrayList<PostModel>> observableRetrofit;
    private static BehaviorSubject<ArrayList<PostModel>> observableModelsList;
    private static Subscription subscription;

    private RetrofitSingleton() {
    }

    public static void init() {

        RxJavaCallAdapterFactory rxAdapter = RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io());

        Gson gson = new GsonBuilder().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(rxAdapter)
                .build();

        UmorilApi apiService = retrofit.create(UmorilApi.class);

        observableRetrofit = apiService.getdata();
    }

    public static void resetModelsObservable() {
        observableModelsList = BehaviorSubject.create();

        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
        subscription = observableRetrofit.subscribe(new Subscriber<ArrayList<PostModel>>() {
            @Override
            public void onCompleted() {
                //do nothing
            }

            @Override
            public void onError(Throwable e) {
                observableModelsList.onError(e);
            }

            @Override
            public void onNext(ArrayList<PostModel> models) {
                observableModelsList.onNext(models);
            }
        });
    }


    public static Observable<ArrayList<PostModel>> getModelsObservable() {
        if (observableModelsList == null) {
            resetModelsObservable();
        }
        return observableModelsList;
    }
}
