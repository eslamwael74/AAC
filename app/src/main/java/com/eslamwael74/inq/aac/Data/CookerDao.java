package com.eslamwael74.inq.aac.Data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by eslamwael74 on 3/21/2018.
 */

@Dao
public interface CookerDao {

    @Insert(onConflict = REPLACE)
    void insert(Cooker cooker);

    @Delete
    void delete(Cooker cooker);

    @Query("SELECT * FROM cooker")
    LiveData<List<Cooker>> getCookers();

    @Query("SELECT * FROM Cooker WHERE id = :id")
    LiveData<Cooker> getCookerById(int id);




}
