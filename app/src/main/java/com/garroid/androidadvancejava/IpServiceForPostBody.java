package com.garroid.androidadvancejava;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IpServiceForPostBody {
    @POST("getIpInfo.php")
    Call<IpModel> getIpMsg(@Body Ip ip); // Body注解将Ip对象转换成JSON字符串，作为请求体
}

class Ip{
    private String ip;
    public Ip(String ip){
        this.ip = ip;
    }
}