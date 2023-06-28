package com.othmanelkourd.moviesbook.domain.usecase

import androidx.paging.PagingData
import com.othmanelkourd.moviesbook.data.repository.IMovieRepository
import com.othmanelkourd.moviesbook.domain.model.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTrendingMoviesUseCase @Inject constructor(private val repository: IMovieRepository) {
    operator fun invoke(): Flow<PagingData<Movie>> {
        return repository.trendingPagingDataSource()
    }
}