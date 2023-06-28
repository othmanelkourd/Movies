package com.othmanelkourd.moviesbook.domain.usecase

import com.othmanelkourd.moviesbook.TestUtils
import com.othmanelkourd.moviesbook.data.datasource.remote.DataState
import com.othmanelkourd.moviesbook.domain.model.MovieDetail
import com.othmanelkourd.moviesbook.repository.MockMovieRepository
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Test

class GetMovieDetailUseCaseTest {

    private lateinit var getMovieDetailsUseCase: GetMovieDetailUseCase
    private lateinit var mockRepository: MockMovieRepository


    @Before
    fun setup() {
        mockRepository = MockMovieRepository()
        getMovieDetailsUseCase = GetMovieDetailUseCase(mockRepository)
    }

    @Test
    fun shouldGetMovieDetailsForId() = runBlocking {
        val movieDetail = TestUtils.mockMovieDetail()
        val movieDetail2 = TestUtils.mockMovieDetail()
        movieDetail.id = 1
        movieDetail2.id = 2
        mockRepository.addMovieDetail(movieDetail)
        mockRepository.addMovieDetail(movieDetail2)

        getMovieDetailsUseCase.invoke(2).collect {
            MatcherAssert.assertThat(it, CoreMatchers.instanceOf(DataState.Success::class.java))
            MatcherAssert.assertThat((it as DataState.Success).data, CoreMatchers.instanceOf(MovieDetail::class.java))
            assert(it.data == movieDetail2)
        }
    }

    @Test
    fun shouldFailToFindMovieDetailsAndThrowError() = runBlocking {
        getMovieDetailsUseCase.invoke(10).collect {
            MatcherAssert.assertThat(it, CoreMatchers.instanceOf(DataState.Error::class.java))
        }
    }
}