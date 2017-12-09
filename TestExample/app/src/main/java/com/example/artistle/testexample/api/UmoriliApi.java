package com.example.artistle.testexample.api;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import com.example.artistle.testexample.PostModel;


public interface UmoriliApi {

    @GET("/users")
    Call<List<PostModel>> getData();
    //Call<List<PostModel>> getData(@Query("name") String resourceName, @Query("num") int count);
}
