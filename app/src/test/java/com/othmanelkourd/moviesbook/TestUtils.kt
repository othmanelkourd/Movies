package com.othmanelkourd.moviesbook

import com.othmanelkourd.moviesbook.domain.model.Movie
import com.othmanelkourd.moviesbook.domain.model.MovieDetail
import java.util.*

object TestUtils {
    fun mockMovie() = Movie(
        false,
        "backdropPath",
        Random().nextInt(),
        "en",
        "tile",
        "",
        1.4,
        "",
        "release date",
        "",
        false,
        6.5,
        15,
    )

    fun mockMovieDetail() = MovieDetail(
        false,
        "backdropPath",
        1200,
        "homepage",
        Random().nextInt(),
        "",
        "",
        "",
        "",
        12.45,
        "",
        "release date",
        12445,
        45,
        "",
        "tagline",
        "title",
        false,
        15.5,
        20
    )
}