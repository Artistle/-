package com.example.artistle.testjob.Api;

import com.example.artistle.testjob.Model.InfoModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface InfoUsers {
    @GET("posts?")
    Call<List<InfoModel>> getInfo(@Query("userId") int id);
}
