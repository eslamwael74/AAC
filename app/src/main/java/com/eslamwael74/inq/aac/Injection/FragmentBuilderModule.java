package com.eslamwael74.inq.aac.Injection;

import com.eslamwael74.inq.aac.Ui.CookerDetails.CookerDetailsFragment;
import com.eslamwael74.inq.aac.Ui.CookerHome.CookerFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by eslamwael74 on 3/24/2018.
 */

@Module
public abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract CookerFragment cookerFragment();

    @ContributesAndroidInjector
    abstract CookerDetailsFragment cookerDetailsFragment();

}
