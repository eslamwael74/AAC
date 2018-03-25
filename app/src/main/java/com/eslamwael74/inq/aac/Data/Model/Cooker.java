package com.eslamwael74.inq.aac.Data.Model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

/**
 * Created by eslamwael74 on 3/21/2018.
 */

@Entity
public class Cooker {

    @PrimaryKey
    @NonNull
    @SerializedName("id")
    private int id;

    @SerializedName("user_name")
    private String name;

    @SerializedName("phone")
    private String phone;


    public Cooker(@NonNull int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    @NonNull
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
