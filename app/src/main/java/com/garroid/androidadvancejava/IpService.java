package com.garroid.androidadvancejava;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IpService {
    @GET("demo/test")
    Call<IpModel> getIpMsg();
}
