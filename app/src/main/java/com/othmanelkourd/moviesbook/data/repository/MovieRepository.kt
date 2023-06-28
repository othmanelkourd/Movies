package com.othmanelkourd.moviesbook.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.othmanelkourd.moviesbook.data.datasource.TrendingPagingDataSource
import com.othmanelkourd.moviesbook.data.datasource.local.MovieDataBase
import com.othmanelkourd.moviesbook.data.datasource.remote.DataState
import com.othmanelkourd.moviesbook.data.datasource.remote.MovieApiService
import com.othmanelkourd.moviesbook.domain.model.MovieDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val apiService: MovieApiService,
    private val db: MovieDataBase
) : IMovieRepository {


    override fun trendingPagingDataSource() = Pager(
        pagingSourceFactory = { TrendingPagingDataSource(apiService, db) },
        config = PagingConfig(pageSize = 1)
    ).flow

    override fun movieDetail(movieId: Int): Flow<DataState<MovieDetail>> = flow {
        emit(DataState.Loading)
        try {
            val searchResult = apiService.movieDetail(movieId)
            db.movieDao.insert(searchResult)
            emit(DataState.Success(searchResult))

        } catch (e: Exception) {
            try {
                val searchResult = db.movieDao.getMovieDetail(movieId)
                if (searchResult != null) {
                    emit(DataState.Success(searchResult))
                } else {
                    emit(DataState.Error(e))
                }
            } catch (e: Exception) {
                emit(DataState.Error(e))
            }
        }
    }
}