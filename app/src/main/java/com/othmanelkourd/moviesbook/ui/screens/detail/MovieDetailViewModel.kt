package com.othmanelkourd.moviesbook.ui.screens.detail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.othmanelkourd.moviesbook.data.datasource.remote.DataState
import com.othmanelkourd.moviesbook.domain.model.MovieDetail
import com.othmanelkourd.moviesbook.domain.usecase.GetMovieDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(private val getMovieDetailsUseCase: GetMovieDetailUseCase) :
    ViewModel() {
    val movieDetail: MutableState<DataState<MovieDetail>?> = mutableStateOf(null)

    fun getMovieDetails(movieId: Int) {
        getMovieDetailsUseCase(movieId).onEach {
                movieDetail.value = it
            }.launchIn(viewModelScope)

    }

}