package com.kino.app.di

import com.kino.app.data.repositories.KINOLocalRepoImpl
import com.kino.app.data.repositories.KINORemoteRepoImpl
import com.kino.app.domain.repositories.KINOLocalRepo
import com.kino.app.domain.repositories.KINORemoteRepo
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
    abstract fun bindKINOLocalRepo(
        _KINOLocalRepo: KINOLocalRepoImpl
    ): KINOLocalRepo

    @Binds
    @Singleton
    abstract fun bindKINORemoteRepo(
        _KINORemoteRepo: KINORemoteRepoImpl
    ): KINORemoteRepo
}