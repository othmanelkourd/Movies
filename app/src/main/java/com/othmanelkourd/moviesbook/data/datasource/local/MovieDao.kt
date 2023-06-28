package com.othmanelkourd.moviesbook.data.datasource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.othmanelkourd.moviesbook.domain.model.Movie
import com.othmanelkourd.moviesbook.domain.model.MovieDetail

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movie: Movie)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(movie: List<Movie>)

    @Query("SELECT * FROM movies")
    suspend fun getAllMovies(): List<Movie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movie: MovieDetail)

    @Query("SELECT * FROM movie_detail WHERE id = :movieId")
    suspend fun getMovieDetail(movieId: Int): MovieDetail?
}