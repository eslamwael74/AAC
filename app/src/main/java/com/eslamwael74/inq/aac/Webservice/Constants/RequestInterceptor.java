package com.eslamwael74.inq.aac.Webservice.Constants;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by eslamwael74 on 3/24/2018.
 */

public class RequestInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        HttpUrl originalHttpUrl = originalRequest.url();

        HttpUrl url = originalHttpUrl.newBuilder().build();

        Request request = originalRequest.newBuilder().url(url).build();
        return chain.proceed(request);
    }


}
