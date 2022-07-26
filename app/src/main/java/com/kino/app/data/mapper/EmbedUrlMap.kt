package com.kino.app.data.mapper

import com.kino.app.data.local.entities.EmbedUrlEnt
import com.kino.app.data.remote.dto.EmbedUrlDto
import com.kino.app.domain.model.EmbedUrl

fun EmbedUrlEnt.toEmbedUrl() : EmbedUrl {
    return EmbedUrl(
        uuid = uuid,
        priority = priority,
        server = server,
        url = url
    )
}


fun EmbedUrl.toEmbedUrlEnt(): EmbedUrlEnt {
    return EmbedUrlEnt(
        uuid = uuid,
        priority = priority,
        server = server,
        url = url
    )
}

fun EmbedUrlDto.toEmbedUrl(): EmbedUrl {
    return EmbedUrl(
        uuid = uuid,
        priority = priority,
        server = server,
        url = url
    )
}

fun List<EmbedUrlDto>.fromEmbedUrlDtoToEmbedUrl(): List<EmbedUrl> {
    var list = mutableListOf<EmbedUrl>()
    iterator().forEach {
        list.add(it.toEmbedUrl())
    }
    return list
}

fun List<EmbedUrlEnt>.fromEmbedUrlEntToEmbedUrl(): List<EmbedUrl> {
    var list = mutableListOf<EmbedUrl>()
    iterator().forEach {
        list.add(it.toEmbedUrl())
    }
    return list
}

fun List<EmbedUrl>.fromEmbedUrlToEmbedUrlEnt(): List<EmbedUrlEnt> {
    var list = mutableListOf<EmbedUrlEnt>()
    iterator().forEach {
        list.add(it.toEmbedUrlEnt())
    }
    return list
}