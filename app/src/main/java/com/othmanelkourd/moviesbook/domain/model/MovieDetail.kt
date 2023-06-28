package com.othmanelkourd.moviesbook.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movie_detail")
data class MovieDetail(
    var adult: Boolean,
    @SerializedName("backdrop_path")
    var backdropPath: String? = "",
    var budget: Int,
    var homepage: String,
    @PrimaryKey
    var id: Int,
    @SerializedName("imdb_id")
    var imdbId: String,
    @SerializedName("original_language")
    var originalLanguage: String,
    @SerializedName("original_title")
    var originalTitle: String,
    var overview: String,
    var popularity: Double,
    @SerializedName("poster_path")
    var posterPath: String? = "empty_path",
    @SerializedName("release_date")
    var releaseDate: String,
    var revenue: Int,
    var runtime: Int,
    var status: String,
    var tagline: String,
    var title: String,
    var video: Boolean,
    @SerializedName("vote_average")
    var voteAverage: Double,
    @SerializedName("vote_count")
    var voteCount: Int
)
