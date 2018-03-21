package com.eslamwael74.inq.aac.Data;

import android.arch.lifecycle.LiveData;

import com.eslamwael74.inq.aac.Webservice.WebService;

import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.Response;

/**
 * Created by eslam on 3/21/2018.
 */
@Singleton
public class CookerRepository {
    private final WebService webService;
    private final CookerDao cookerDao;
    private final Executor executor;


    @Inject
    public CookerRepository(WebService webService, CookerDao cookerDao, Executor executor) {
        this.webService = webService;
        this.cookerDao = cookerDao;
        this.executor = executor;
    }


    public LiveData<List<Cooker>> getListOfCooker(){
        return cookerDao.getCookers();
    }
    private void refresh(){
        executor.execute( () -> {



        });
    }

}
