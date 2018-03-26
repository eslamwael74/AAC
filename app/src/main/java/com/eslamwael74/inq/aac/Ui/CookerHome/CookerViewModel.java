package com.eslamwael74.inq.aac.Ui.CookerHome;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;

import com.eslamwael74.inq.aac.Data.Model.Cooker;
import com.eslamwael74.inq.aac.Data.Repository.CookerRepository;
import com.eslamwael74.inq.aac.Utils.AbsentLiveData;
import com.eslamwael74.inq.aac.Webservice.Constants.Resource;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by eslamwael74 on 3/21/2018.
 */

public class CookerViewModel extends ViewModel {

    private LiveData<Resource<List<Cooker>>> cookerLiveData;
    private CookerRepository cookerRepository;
    private MutableLiveData<UserData>mutableLiveData = new MutableLiveData<>();

    @Inject
    CookerViewModel(CookerRepository cookerRepository) {
        cookerLiveData = Transformations.switchMap(mutableLiveData, input -> {
            if (input == null){
                return AbsentLiveData.create();
            }
            return cookerRepository.loadCookers(input.token,input.lat,input.lng);
        });
    }

    public LiveData<Resource<List<Cooker>>> getCookerLiveData() {
        return cookerLiveData;
    }


    public void init(String token,String lat,String lng) {
        UserData userData = new UserData(token, lat, lng);
        mutableLiveData.setValue(userData);
    }

    static class UserData {
        String token;
        String lat;
        String lng;

        public UserData(String token, String lat, String lng) {
            this.token = token;
            this.lat = lat;
            this.lng = lng;
        }

        boolean isEmpty(){
            return token == null || lat == null || lng == null;
        }
    }

}
