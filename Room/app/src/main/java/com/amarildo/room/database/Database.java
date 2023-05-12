package com.amarildo.room.database;

import androidx.room.RoomDatabase;

import com.amarildo.room.model.User;

@androidx.room.Database(entities = {User.class}, version = 1)
public abstract class Database extends RoomDatabase {

    // Nome del database
    public static final String NOME_DB = "MyDatabase";

    public abstract UserDao userDao();
}
