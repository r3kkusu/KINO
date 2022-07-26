package com.kino.app.data.mapper

import com.kino.app.data.local.entities.CountryEnt
import com.kino.app.data.remote.dto.CountryDto
import com.kino.app.domain.model.Country

fun CountryEnt.toCountry() : Country {
    return Country(
        name = name,
        uuid = uuid
    )
}


fun Country.toCountryEnt(): CountryEnt {
    return CountryEnt(
        name = name,
        uuid = uuid
    )
}

fun CountryDto.toCountry(): Country {
    return Country(
        name = name,
        uuid = uuid
    )
}

fun List<CountryDto>.fromCountryDtoToCountry(): List<Country> {
    var list = mutableListOf<Country>()
    iterator().forEach {
        list.add(it.toCountry())
    }
    return list
}

fun List<CountryEnt>.fromCountryEntToCountry(): List<Country> {
    var list = mutableListOf<Country>()
    iterator().forEach {
        list.add(it.toCountry())
    }
    return list
}

fun List<Country>.fromCountryToCountryEnt(): List<CountryEnt> {
    var list = mutableListOf<CountryEnt>()
    iterator().forEach {
        list.add(it.toCountryEnt())
    }
    return list
}