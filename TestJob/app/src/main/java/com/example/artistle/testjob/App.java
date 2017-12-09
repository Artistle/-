package com.example.artistle.testjob;

import android.app.Application;

import com.example.artistle.testjob.Api.InfoUsers;
import com.example.artistle.testjob.Api.UmorilApi;
import com.example.artistle.testjob.Retrofit.RetrofitSingleton;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {

    private static UmorilApi umoriliApi;
    private static InfoUsers infoUsers;
    private Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();

       retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        umoriliApi = retrofit.create(UmorilApi.class);
        infoUsers = retrofit.create(InfoUsers.class);
        RetrofitSingleton.init();
    }

    public static UmorilApi getApi() {
        return umoriliApi;
    }

    public static InfoUsers getInfoUsers() {
        return infoUsers;
    }

}
