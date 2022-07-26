package com.kino.app.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "country_table")
data class CountryEnt(
    var name: String,
    @PrimaryKey val uuid: String
)