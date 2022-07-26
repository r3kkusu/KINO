package com.kino.app.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "genre_table")
data class GenreEnt(
    var name: String,
    @PrimaryKey var uuid: String
)