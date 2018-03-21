package com.eslamwael74.inq.aac.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.eslamwael74.inq.aac.Data.Cooker;
import com.eslamwael74.inq.aac.Data.CookerRepository;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by eslamwael74 on 3/21/2018.
 */

public class CookerViewModel extends ViewModel {

    private LiveData<Cooker> cookerLiveData;
    private CookerRepository cookerRepository;


    public CookerViewModel(CookerRepository cookerRepository){
        this.cookerRepository = cookerRepository;
    }




}
