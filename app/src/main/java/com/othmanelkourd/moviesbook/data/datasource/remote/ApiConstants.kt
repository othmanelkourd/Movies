package com.othmanelkourd.moviesbook.data.datasource.remote

object ApiConstants {
    private const val API_KEY = "c9856d0cb57c3f14bf75bdc6c063b8f3"
    private const val DEFAULT_LANGUAGE = "en-US"
    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val IMAGE_URL = "https://image.tmdb.org/t/p/w342"
    const val TRENDING_MOVIE_LIST = "discover/movie?api_key=$API_KEY&language=$DEFAULT_LANGUAGE"
    const val MOVIE_DETAIL = "movie/{movieId}?api_key=$API_KEY&language=$DEFAULT_LANGUAGE"
}