package com.eslamwael74.inq.aac.Injection;

import android.app.Application;

import com.eslamwael74.inq.aac.AacApplication;

import dagger.Module;
import dagger.Provides;

/**
 * Created by eslamwael74 on 3/21/2018.
 */

@Module
public class ApplicationModule {
    private final AacApplication aacApplication;

    public ApplicationModule(AacApplication aacApplication) {
        this.aacApplication = aacApplication;
    }


    @Provides
    AacApplication provideAacApplication() {
        return aacApplication;
    }

    @Provides
    Application provideApplication() {
        return aacApplication;
    }

}
