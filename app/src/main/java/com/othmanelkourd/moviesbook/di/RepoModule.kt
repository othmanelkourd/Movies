package com.othmanelkourd.moviesbook.di

import com.othmanelkourd.moviesbook.data.datasource.local.MovieDataBase
import com.othmanelkourd.moviesbook.data.datasource.remote.MovieApiService
import com.othmanelkourd.moviesbook.data.repository.IMovieRepository
import com.othmanelkourd.moviesbook.data.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {
    @Singleton
    @Provides
    fun provideMovieRepository(
        apiService: MovieApiService,
        db: MovieDataBase
    ): IMovieRepository {
        return MovieRepository(apiService, db)
    }

}