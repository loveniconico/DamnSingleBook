package com.wmsswj.damnsinglebook.model.sql

import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

abstract class RunningAccount : RoomDatabase(){
    abstract fun RunningAccountDAO(): RunningAccountDAO
    companion object {
        private var INSTANCE: RunningAccount? = null

        fun getInstance(context: Context): RunningAccount? {
            if (INSTANCE == null) {
                synchronized(RunningAccount::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                            RunningAccount::class.java, "mydb.db")
                            .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}
