package com.example.artistle.testjob.Api;

import android.util.Log;

import com.example.artistle.testjob.App;
import com.example.artistle.testjob.Model.PostModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


public interface UmorilApi {

    /*@GET("users")
    Call<List<PostModel>> getData()*/;
    @GET("users")
    Observable<ArrayList<PostModel>> getdata();
}