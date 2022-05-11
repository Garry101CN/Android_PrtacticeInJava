package com.garroid.androidadvancejava;

public class IpModel {
    private IpData data;

    private String msg;

    private int code;

    public void setData(IpData data){
        this.data = data;
    }
    public IpData getData(){
        return this.data;
    }
    public void setMsg(String msg){
        this.msg = msg;
    }
    public String getMsg(){
        return this.msg;
    }
    public void setCode(int code){
        this.code = code;
    }
    public int getCode(){
        return this.code;
    }

}