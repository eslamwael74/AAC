package com.eslamwael74.inq.aac.Injection;

import com.eslamwael74.inq.aac.AacApplication;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by eslamwael74 on 3/21/2018.
 */

@Singleton
@Component(modules = {AacApplication.class, RoomModule.class})
public interface ApplicationComponent {



}
