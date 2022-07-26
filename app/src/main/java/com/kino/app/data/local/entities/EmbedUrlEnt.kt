package com.kino.app.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "embed_url_table")
data class EmbedUrlEnt(
    @PrimaryKey(autoGenerate = true)
    var uuid: Int,
    var priority: Int,
    var server: String,
    var url: String
)