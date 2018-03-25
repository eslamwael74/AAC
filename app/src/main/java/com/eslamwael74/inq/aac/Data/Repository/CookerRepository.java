package com.eslamwael74.inq.aac.Data.Repository;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.eslamwael74.inq.aac.Data.Model.Cooker;
import com.eslamwael74.inq.aac.Data.Dao.CookerDao;
import com.eslamwael74.inq.aac.Utils.AppExecutors;
import com.eslamwael74.inq.aac.Utils.RateLimiter;
import com.eslamwael74.inq.aac.Webservice.ModelResponse.CookerResponse;
import com.eslamwael74.inq.aac.Webservice.Constants.NetworkBoundResource;
import com.eslamwael74.inq.aac.Webservice.Constants.Resource;
import com.eslamwael74.inq.aac.Webservice.Constants.WebService;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;

/**
 * Created by eslamwael74 on 3/21/2018.
 */
@Singleton
public class CookerRepository {

    private final WebService webService;
    private final CookerDao cookerDao;
    private final RateLimiter<String> rateLimiter = new RateLimiter<>(1, TimeUnit.MINUTES);
    private final AppExecutors appExecutors;


    @Inject
    CookerRepository(WebService webService, CookerDao cookerDao, AppExecutors appExecutors) {
        this.webService = webService;
        this.cookerDao = cookerDao;
        this.appExecutors = appExecutors;
    }


    public LiveData<List<Cooker>> getListOfCooker() {
        return cookerDao.getCookers();
    }

    public LiveData<Cooker> getCooker(int cookerId) {
        return cookerDao.getCookerById(cookerId);
    }

    public LiveData<Resource<List<Cooker>>> loadCookers(String token,String lat,String lng) {

        RequestBody rToken = RequestBody.create(MediaType.parse("text/plain"), token);
        RequestBody rLat = RequestBody.create(MediaType.parse("text/plain"), lat);
        RequestBody rLng = RequestBody.create(MediaType.parse("text/plain"), lng);

        return new NetworkBoundResource<List<Cooker>, CookerResponse>(appExecutors) {

            @Override
            protected void saveCallResult(@NonNull CookerResponse item) {
                cookerDao.insert(item.getCookers());
            }

            @Override
            protected boolean shouldFetch(@Nullable List<Cooker> data) {
                return data == null || data.isEmpty() || rateLimiter.shouldFetch(token);
            }

            @NonNull
            @Override
            protected LiveData<List<Cooker>> loadFromDb() {
                return cookerDao.getCookers();
            }

            @NonNull
            @Override
            protected Call<CookerResponse> createCall() {
                return webService.getCookers(rToken,rLat,rLng);
            }

            @Override
            protected void onFetchFailed() {
                rateLimiter.reset(token);
            }
        }.getAsLiveData();


    }

}
