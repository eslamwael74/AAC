package com.eslamwael74.inq.aac.Injection;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.persistence.room.Room;

import com.eslamwael74.inq.aac.Data.CookerDao;
import com.eslamwael74.inq.aac.Data.CookerDatabase;

import javax.inject.Singleton;

import dagger.Provides;

/**
 * Created by eslamwael74 on 3/21/2018.
 */

public class RoomModule {

    private final CookerDatabase cookerDatabase;

    public RoomModule(Application application){
        this.cookerDatabase = Room.databaseBuilder(
                application,CookerDatabase.class,"Cooker.db").build();
    }


    //here we need provide repository class

    @Provides
    @Singleton
    CookerDao provideCookerDao(CookerDatabase cookerDatabase){
        return cookerDatabase.cookerDao();
    }

    @Provides
    @Singleton
    CookerDatabase provideCookerDatabase(Application application){
        return cookerDatabase;
    }

    @Provides
    @Singleton
    ViewModelProvider.Factory provideViewModelFactory(){
        return null;
    }

}
