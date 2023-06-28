package com.othmanelkourd.moviesbook.ui.screens.trending

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.othmanelkourd.moviesbook.domain.usecase.GetTrendingMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TrendingMovieViewModel @Inject constructor(getListOfPopularMoviesUseCase: GetTrendingMoviesUseCase) :
    ViewModel() {
    val popularMovies = getListOfPopularMoviesUseCase.invoke().cachedIn(viewModelScope)
}