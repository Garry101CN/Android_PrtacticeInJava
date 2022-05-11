package com.garroid.androidadvancejava;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
// 只能传递一个参数的Get请求
public interface IpServiceForQuery {

    @GET("getIpInfo.php")
    Call<IpModel> getIpMsg(@Query("ip") String ip);
}
