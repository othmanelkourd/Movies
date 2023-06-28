package com.othmanelkourd.moviesbook.repository

import androidx.paging.PagingData
import com.othmanelkourd.moviesbook.data.datasource.remote.DataState
import com.othmanelkourd.moviesbook.data.repository.IMovieRepository
import com.othmanelkourd.moviesbook.domain.model.Movie
import com.othmanelkourd.moviesbook.domain.model.MovieDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MockMovieRepository : IMovieRepository {

    private var movies = mutableListOf<Movie>()
    private var movieDetails = mutableListOf<MovieDetail>()


    override fun trendingPagingDataSource(): Flow<PagingData<Movie>> {
        return flow { emit(PagingData.from(movies)) }
    }

    override fun movieDetail(movieId: Int): Flow<DataState<MovieDetail>> {
        movieDetails.find { it.id == movieId }?.let {
            return flow { emit(DataState.Success(it)) }
        }
        return flow { emit(DataState.Error(Exception("Movie not found"))) }
    }

     fun addMovie(movie: Movie) {
        movies.add(movie)
    }
     fun addMovieDetail(movieDetail: MovieDetail) {
        movieDetails.add(movieDetail)
    }
}