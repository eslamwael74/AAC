package com.eslamwael74.inq.aac.Injection;

import android.app.Application;

import com.eslamwael74.inq.aac.AacApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;


/**
 * Created by eslamwael74 on 20/05/2017.
 */
@Singleton
@Component(modules = {AppModule.class, AndroidInjectionModule.class, ActivityBuilderModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(AacApplication aaApp);
}
