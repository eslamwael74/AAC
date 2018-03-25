package com.eslamwael74.inq.aac.Injection;

import com.eslamwael74.inq.aac.Ui.CookerDetails.DetailsActivity;
import com.eslamwael74.inq.aac.Ui.CookerHome.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by eslamwael74 on 3/24/2018.
 */

@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = FragmentBuilderModule.class)
    abstract MainActivity mainActivity();

    @ContributesAndroidInjector(modules = FragmentBuilderModule.class)
    abstract DetailsActivity detailsActivity();

}
