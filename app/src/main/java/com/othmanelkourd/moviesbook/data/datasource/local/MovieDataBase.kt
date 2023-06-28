package com.othmanelkourd.moviesbook.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.othmanelkourd.moviesbook.domain.model.Movie
import com.othmanelkourd.moviesbook.domain.model.MovieDetail


@Database(entities = [Movie::class, MovieDetail::class], version = 1, exportSchema = false)
abstract class MovieDataBase : RoomDatabase() {
    abstract val movieDao: MovieDao

    companion object {
        const val DATABASE_NAME = "movies_db"
    }
}