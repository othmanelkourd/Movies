package com.othmanelkourd.moviesbook.domain.usecase

import com.othmanelkourd.moviesbook.data.datasource.remote.DataState
import com.othmanelkourd.moviesbook.data.repository.IMovieRepository
import com.othmanelkourd.moviesbook.domain.model.MovieDetail
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(private val repo: IMovieRepository) {
    operator fun invoke(movieId: Int): Flow<DataState<MovieDetail>> =
        repo.movieDetail(movieId)
}