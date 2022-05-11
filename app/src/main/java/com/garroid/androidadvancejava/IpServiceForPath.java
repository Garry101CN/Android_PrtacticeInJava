package com.garroid.androidadvancejava;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IpServiceForPath {

    @GET("{path}/getIpInfo.php?=183.230.12.219")
    Call<IpModel> getIpMsg(@Path("path") String path);

}
