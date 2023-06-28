package com.othmanelkourd.moviesbook.data.repository

import androidx.paging.PagingData
import com.othmanelkourd.moviesbook.data.datasource.remote.DataState
import com.othmanelkourd.moviesbook.domain.model.Movie
import com.othmanelkourd.moviesbook.domain.model.MovieDetail
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {
    fun trendingPagingDataSource(): Flow<PagingData<Movie>>
    fun movieDetail(movieId: Int): Flow<DataState<MovieDetail>>
}