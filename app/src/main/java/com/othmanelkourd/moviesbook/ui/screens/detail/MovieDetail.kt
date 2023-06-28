package com.othmanelkourd.moviesbook.ui.screens.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.othmanelkourd.moviesbook.R
import com.othmanelkourd.moviesbook.data.datasource.remote.ApiConstants
import com.othmanelkourd.moviesbook.data.datasource.remote.DataState
import com.othmanelkourd.moviesbook.domain.model.MovieDetail
import com.othmanelkourd.moviesbook.ui.component.text.SubtitlePrimary
import com.othmanelkourd.moviesbook.ui.theme.AppBackgroundColor
import com.othmanelkourd.moviesbook.ui.theme.PrimaryTextColor
import com.othmanelkourd.moviesbook.ui.theme.SecondaryTextColor
import com.othmanelkourd.moviesbook.utils.toDuration


@Composable
fun MovieDetail(movieId: Int) {
    val movieDetailViewModel = hiltViewModel<MovieDetailViewModel>()
    val movieDetail = movieDetailViewModel.movieDetail

    LaunchedEffect(true) {
        movieDetailViewModel.getMovieDetails(movieId)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                AppBackgroundColor
            )
    ) {
        movieDetail.value?.let { it ->
            if (it is DataState.Success<MovieDetail>) {
                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .padding(top = 6.dp)
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(ApiConstants.IMAGE_URL.plus(it.data.posterPath)),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(500.dp)
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 16.dp, end = 16.dp)
                    ) {
                        Text(
                            text = it.data.title,
                            modifier = Modifier.padding(top = 10.dp),
                            color = PrimaryTextColor,
                            fontSize = 30.sp,
                            fontWeight = FontWeight.ExtraBold,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 10.dp, top = 10.dp)
                        ) {

                            Column(Modifier.weight(1f)) {
                                SubtitlePrimary(
                                    text = it.data.releaseDate
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.ic_release_date),
                                    contentDescription = null,
                                    Modifier.size(30.dp)
                                )
                            }

                            Column(Modifier.weight(1f)) {
                                SubtitlePrimary(
                                    text = it.data.voteAverage.toString(),
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.ic_movie_rating),
                                    contentDescription = null,
                                    Modifier.size(30.dp)
                                )
                            }
                            Column(Modifier.weight(1f)) {
                                SubtitlePrimary(
                                    text = it.data.runtime.toDuration()
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.ic_movie_duration),
                                    contentDescription = null,
                                    Modifier.size(20.dp)
                                )
                            }
                            Column(Modifier.weight(1f)) {
                                SubtitlePrimary(
                                    text = it.data.originalLanguage,
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.ic_movie_language),
                                    contentDescription = null,
                                    Modifier.size(30.dp)
                                )
                            }

                        }
                        Text(
                            text = stringResource(R.string.overview),
                            color = PrimaryTextColor,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(
                            text = it.data.overview,
                            color = SecondaryTextColor,
                            fontSize = 13.sp,
                            modifier = Modifier.padding(bottom = 10.dp)
                        )
                    }
                }
            }
        }
    }
}
