package com.othmanelkourd.moviesbook

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.othmanelkourd.TestUtils.mockMovie
import com.othmanelkourd.TestUtils.mockMovieDetail
import com.othmanelkourd.moviesbook.data.datasource.local.MovieDao
import com.othmanelkourd.moviesbook.data.datasource.local.MovieDataBase
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MoviesDaoTest {

    private lateinit var database: MovieDataBase
    private lateinit var dao: MovieDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            MovieDataBase::class.java
        ).allowMainThreadQueries().build()
        dao = database.movieDao
    }

    @After
    fun closeDatabase() {
        database.close()
    }


    @Test
    fun insertMovie_returnsTrue() = runBlocking {
        val movie = mockMovie()
        dao.insert(movie)
        val movies = dao.getAllMovies()
        assertTrue(movies.contains(movie))
    }

    @Test
    fun insertMovieDetail_returnsTrue() = runBlocking {
        val mockDetail = mockMovieDetail()
        dao.insert(mockDetail)
        val movieDetail = dao.getMovieDetail(mockDetail.id)

        assertEquals(mockDetail.id, movieDetail?.id)
        assertEquals(mockDetail.originalLanguage, movieDetail?.originalLanguage)
        assertEquals(mockDetail.homepage, movieDetail?.homepage)
    }

    @Test
    fun insertAllMovies_returnsTrue() = runBlocking {
        val list = listOf(mockMovie(), mockMovie(), mockMovie())
        dao.insertAll(list)
        val movies = dao.getAllMovies()
        assertEquals(list.size, movies.size)
    }
}