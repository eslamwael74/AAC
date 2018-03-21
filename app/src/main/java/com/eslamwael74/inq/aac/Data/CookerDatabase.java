package com.eslamwael74.inq.aac.Data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by eslamwael74 on 3/21/2018.
 */

@Database(entities = {Cooker.class},version = 1)
public abstract class CookerDatabase extends RoomDatabase {

    public abstract CookerDao cookerDao();

}
