package com.kino.app.di

import com.kino.app.data.repositories.KINOApiRepoImpl
import com.kino.app.data.repositories.KINODbRepoImpl
import com.kino.app.domain.repositories.KINOApiRepo
import com.kino.app.domain.repositories.KINODbRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindKINODbRepo(
        kinoDbRepoImpl: KINODbRepoImpl
    ): KINODbRepo

    @Binds
    @Singleton
    abstract fun bindKINOApiRepo(
        kinoApiRepoImpl: KINOApiRepoImpl
    ): KINOApiRepo
}