package com.kino.app.di

import android.app.Application
import androidx.room.Room
import com.kino.app.data.local.KINODatabase
import com.kino.app.data.remote.KINOApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideMovieApi(): KINOApi {
        return Retrofit.Builder()
            .baseUrl(KINOApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }).build())
            .build()
            .create(KINOApi::class.java)
    }

    @Provides
    @Singleton
    fun provideKINODatabase(app: Application): KINODatabase {
        return Room.databaseBuilder(
            app,
            KINODatabase::class.java,
            KINODatabase.DATABASE_NAME
        ).build()
    }
}