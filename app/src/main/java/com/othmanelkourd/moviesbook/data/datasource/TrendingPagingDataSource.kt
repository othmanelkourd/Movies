package com.othmanelkourd.moviesbook.data.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.othmanelkourd.moviesbook.data.datasource.local.MovieDataBase
import com.othmanelkourd.moviesbook.data.datasource.remote.MovieApiService
import com.othmanelkourd.moviesbook.domain.model.Movie
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException
import javax.inject.Inject

class TrendingPagingDataSource @Inject constructor(
    private val apiService: MovieApiService,
    private val db: MovieDataBase
) :
    PagingSource<Int, Movie>() {

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val nextPage = params.key ?: 1
            val movieList = apiService.trendingMovies(nextPage)
            db.movieDao.insertAll(movieList.results)
            LoadResult.Page(
                data = movieList.results,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = if (movieList.results.isNotEmpty()) movieList.page.plus(1) else null
            )
        } catch (exception: IOException) {
            Timber.e("Exception ${exception.message}")
            loadFromDatabase()
        } catch (httpException: HttpException) {
            Timber.e("httpException ${httpException.message}")
            LoadResult.Error(httpException)
        }
    }

    private suspend fun loadFromDatabase(): LoadResult<Int, Movie> {
        return try {
            val movieList = db.movieDao.getAllMovies()
            LoadResult.Page(
                data = movieList,
                prevKey = null,
                nextKey = null
            )
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }
}