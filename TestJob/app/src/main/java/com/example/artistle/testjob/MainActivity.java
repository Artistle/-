package com.example.artistle.testjob;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.artistle.testjob.Adapter.PostAdapter;
import com.example.artistle.testjob.Api.UmorilApi;
import com.example.artistle.testjob.Model.PostModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<PostModel> posts;
    UmorilApi um;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        posts = new ArrayList<PostModel>();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        PostAdapter adapter = new PostAdapter(posts);
        recyclerView.setAdapter(adapter);
        //UserResponse();
        Responce();
    }

       /* public void UserResponse(){
        App.getApi().getData().enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                posts.addAll(response.body());
                recyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "An error occurred during networking", Toast.LENGTH_SHORT).show();
            }
        });
    }*/

       public void Responce(){
           Observable<ArrayList<PostModel>> resp = um.getdata();
           resp.subscribeOn(Schedulers.newThread())
                   .observeOn(AndroidSchedulers.mainThread())
                   //.map(issues -> issues)    //get issues and map to issues list
                   .subscribe(new Subscriber<List<PostModel>>() {
                       @Override
                       public void onCompleted() {

                       }

                       @Override
                       public void onError(Throwable e) {

                       }

                       @Override
                       public void onNext(List<PostModel> posts) {
                           posts.addAll(posts);
                           //recyclerView.getAdapter().notifyDataSetChanged();
                       }
                   });
       }
}
