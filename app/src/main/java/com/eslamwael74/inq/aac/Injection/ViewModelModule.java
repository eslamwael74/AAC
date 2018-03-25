package com.eslamwael74.inq.aac.Injection;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.eslamwael74.inq.aac.Ui.CookerDetails.CookerDetailsViewModel;
import com.eslamwael74.inq.aac.Ui.CookerHome.CookerViewModel;
import com.eslamwael74.inq.aac.ViewModel.CustomViewModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;


/**
 * Created by eslamwael74 on 19/06/2017.
 */

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CookerViewModel.class)
    abstract ViewModel bindsCookerListViewModel(CookerViewModel cookerViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(CookerDetailsViewModel.class)
    abstract ViewModel bindsCookerViewModel(CookerDetailsViewModel cookerDetailsViewModel);

    @Binds
    abstract ViewModelProvider.Factory factory(CustomViewModelFactory modelFactory);

}
