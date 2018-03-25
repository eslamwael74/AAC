package com.eslamwael74.inq.aac.Webservice.Constants;

import com.eslamwael74.inq.aac.Webservice.ModelResponse.CookerResponse;

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
    Call<CookerResponse> getCookers(@Part("token_api") RequestBody token,
                                    @Part("latitude") RequestBody latitude,
                                    @Part("longitude") RequestBody longitude);

}
