package com.othmanelkourd.moviesbook.domain.usecase

import androidx.paging.map
import com.othmanelkourd.moviesbook.TestUtils
import com.othmanelkourd.moviesbook.domain.model.Movie
import com.othmanelkourd.moviesbook.repository.MockMovieRepository
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Test

class GetTrendingMoviesUseCaseTest {
    private lateinit var mockRepository: MockMovieRepository
    private lateinit var getTrendingMoviesUseCase: GetTrendingMoviesUseCase

    @Before
    fun setup() {
        mockRepository = MockMovieRepository()
        getTrendingMoviesUseCase = GetTrendingMoviesUseCase(mockRepository)
    }

    @Test
    fun getTrendingMoviesUseCaseTest() = runBlocking {
        val movie = TestUtils.mockMovie()
        val movie2 = TestUtils.mockMovie()
        mockRepository.addMovie(movie)
        mockRepository.addMovie(movie2)
        getTrendingMoviesUseCase.invoke().collect { result->
            result.map {
                assert(listOf(movie.id, movie2.id).contains(it.id))
                MatcherAssert.assertThat(it, CoreMatchers.instanceOf(Movie::class.java))
            }
        }
    }
}