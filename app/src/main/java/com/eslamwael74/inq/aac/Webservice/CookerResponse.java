package com.eslamwael74.inq.aac.Webservice;

import com.eslamwael74.inq.aac.Data.Cooker;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by eslamwael74 on 3/21/2018.
 */


public class CookerResponse {

    @SerializedName("status_code")
    int statusCode;


    @SerializedName("cookers")
    List<Cooker> cookers;


    public int getStatusCode() {
        return statusCode;
    }

    public List<Cooker> getCookers() {
        return cookers;
    }
}
