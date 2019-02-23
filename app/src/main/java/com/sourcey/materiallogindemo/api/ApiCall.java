package com.sourcey.materiallogindemo.api;

import com.sourcey.materiallogindemo.model.LoginModel;
import com.sourcey.materiallogindemo.model.RegisterModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiCall {

    //login user
    @FormUrlEncoded
    @POST("login")
    Call<LoginModel> loginRequest(@Field("username")String username_user,
                                  @Field("password")String password_user);


    //Register user
    @FormUrlEncoded
    @POST("add")
    Call<RegisterModel> registerRequest(@Field("username") String username_user,
                                        @Field("password") String password_user,
                                        @Field("email") String email_user,
                                        @Field("role") String role_user);
}
