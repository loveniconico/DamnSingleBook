package com.wmsswj.damnsinglebook.model.sql

import android.arch.persistence.room.Query

interface RunningAccountDAO {
    @get:Query("SELECT * FROM RunningAccount")
    val all: List<RunningAccountDatabase>

    @Query("SELECT * FROM RunningAccount WHERE id IN (:ids)")
    fun loadAllByIds(ids: IntArray): List<RunningAccountDatabase>

    @Query("SELECT * FROM RunningAccount WHERE id IN (:id) LIMIT 1")
    fun itemById(id:Int) : RunningAccountDatabase

}