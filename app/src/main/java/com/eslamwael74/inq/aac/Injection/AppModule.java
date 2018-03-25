package com.eslamwael74.inq.aac.Injection;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.eslamwael74.inq.aac.Data.Dao.CookerDao;
import com.eslamwael74.inq.aac.Data.Database.CookerDatabase;
import com.eslamwael74.inq.aac.Webservice.Constants.ApiConstants;
import com.eslamwael74.inq.aac.Webservice.Constants.RequestInterceptor;
import com.eslamwael74.inq.aac.Webservice.Constants.WebService;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by eslamwael74 on 20/05/2017.
 */
@Module(includes = ViewModelModule.class)
public class AppModule {

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.connectTimeout(ApiConstants.TIMEOUT_IN_SEC, TimeUnit.SECONDS);
        okHttpClient.readTimeout(ApiConstants.TIMEOUT_IN_SEC, TimeUnit.SECONDS);
        okHttpClient.addInterceptor(new RequestInterceptor());
        return okHttpClient.build();
    }

    @Provides
    @Singleton
    WebService provideRetrofit(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit.create(WebService.class);
    }

    @Provides
    @Singleton
    CookerDatabase provideCookerDatabase(Application application) {
        return Room.databaseBuilder(application, CookerDatabase.class, "cooker.db").build();
    }

    @Provides
    @Singleton
    CookerDao provideCookerDao(CookerDatabase cookerDatabase) {
        return cookerDatabase.cookerDao();
    }

}
