package com.ricky.project_get.service;

import com.ricky.project_get.model.RandomUserResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {
    @GET("/api/")
    Call<RandomUserResponse> getRandomUser();
}
