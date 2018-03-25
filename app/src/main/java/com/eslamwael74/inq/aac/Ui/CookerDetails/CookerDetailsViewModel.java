package com.eslamwael74.inq.aac.Ui.CookerDetails;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.eslamwael74.inq.aac.Data.Model.Cooker;
import com.eslamwael74.inq.aac.Data.Repository.CookerRepository;
import com.eslamwael74.inq.aac.Webservice.Constants.Resource;

import javax.inject.Inject;

/**
 * Created by eslamwael74 on 3/25/2018.
 */

public class CookerDetailsViewModel extends ViewModel {

    private final LiveData<Resource<Cooker>> cookerLiveData = new MutableLiveData<>();
    private final CookerRepository cookerRepository;

    @Inject
    public CookerDetailsViewModel(CookerRepository cookerRepository) {
        this.cookerRepository = cookerRepository;
    }

    public LiveData<Cooker> getCooker(int cookerId) {
        return cookerRepository.getCooker(cookerId);
    }
}
