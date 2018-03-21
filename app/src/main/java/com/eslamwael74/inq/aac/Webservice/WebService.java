package com.eslamwael74.inq.aac.Webservice;

import android.arch.lifecycle.LiveData;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by eslamwael74 on 3/21/2018.
 */

public interface WebService {


    @Multipart
    @POST("user_home")
    LiveData<CookerResponse> getCookers(@Part("token_api") RequestBody token,
                                        @Part("latitude") RequestBody latitude,
                                        @Part("longitude") RequestBody longitude);

}
