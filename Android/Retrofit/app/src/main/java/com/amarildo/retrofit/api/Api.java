package com.amarildo.retrofit.api;

import com.amarildo.retrofit.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "https://jsonplaceholder.typicode.com/";

    @GET("posts")
    Call<List<Post>> getAllPosts();
}
