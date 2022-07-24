package com.kino.app.di

import com.kino.app.data.repositories.KINORepoImpl
import com.kino.app.domain.repositories.KINORepo
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
    abstract fun bindKINORepo(
        kinoRepoImpl: KINORepoImpl
    ): KINORepo
}