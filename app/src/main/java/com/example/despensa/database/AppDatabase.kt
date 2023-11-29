package com.example.despensa.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.despensa.dao.UserDao
import com.example.despensa.entity.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun userDao(): UserDao
}