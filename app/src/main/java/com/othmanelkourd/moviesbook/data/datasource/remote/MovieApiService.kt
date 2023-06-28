package com.othmanelkourd.moviesbook.data.datasource.remote

import com.othmanelkourd.moviesbook.domain.model.MovieDetail
import com.othmanelkourd.moviesbook.domain.model.PageModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiService {

    @GET(ApiConstants.TRENDING_MOVIE_LIST)
    suspend fun trendingMovies(@Query("page") page: Int): PageModel

    @GET(ApiConstants.MOVIE_DETAIL)
    suspend fun movieDetail(@Path("movieId") movieId: Int): MovieDetail
}