package com.wmsswj.damnsinglebook.model.sql

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "RunningAccount")
class RunningAccountDatabase(
        @PrimaryKey(autoGenerate = true) var id: Int?,

        @ColumnInfo(name = "amount") var amount: Int?,

        @ColumnInfo(name = "information") var information: String?,

        @ColumnInfo(name = "consumption_type") var consumptionType: String?,

        @ColumnInfo(name = "add_date") var addDate: String?

) {
    constructor() : this(null, 0, "",
            "", "")
}