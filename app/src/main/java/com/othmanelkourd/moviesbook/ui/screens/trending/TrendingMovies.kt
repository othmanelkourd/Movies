package com.othmanelkourd.moviesbook.ui.screens.trending

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridItemScope
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.rememberAsyncImagePainter
import com.othmanelkourd.moviesbook.R
import com.othmanelkourd.moviesbook.data.datasource.remote.ApiConstants
import com.othmanelkourd.moviesbook.domain.model.Movie
import com.othmanelkourd.moviesbook.navigation.Screen
import com.othmanelkourd.moviesbook.ui.component.text.SubtitlePrimary
import com.othmanelkourd.moviesbook.ui.component.text.SubtitleSecondary
import com.othmanelkourd.moviesbook.ui.component.text.TitlePrimary
import com.othmanelkourd.moviesbook.ui.theme.AppBackgroundColor
import com.othmanelkourd.moviesbook.ui.theme.Purple200
import com.othmanelkourd.moviesbook.ui.theme.cornerRadius6
import kotlinx.coroutines.flow.Flow

@Composable
fun TrendingMovies(
    navController: NavController,
) {
    val nowPlayViewModel = hiltViewModel<TrendingMovieViewModel>()
    MovieListScreen(
        navController = navController,
        movies = nowPlayViewModel.popularMovies
    )
}

@Composable
fun MovieListScreen(
    navController: NavController, movies: Flow<PagingData<Movie>>
) {
    val moviesItems: LazyPagingItems<Movie> = movies.collectAsLazyPagingItems()

    Column(modifier = Modifier.background(AppBackgroundColor)) {

        TitlePrimary(
            text = "Trending movies", Modifier
                .align(Alignment.CenterHorizontally)
                .padding(6.dp)
        )

        LazyVerticalGrid(columns = GridCells.Fixed(2),
            modifier = Modifier.padding(start = 5.dp, top = 5.dp, end = 5.dp),
            content = {
                items(moviesItems) { item ->
                    item?.let {
                        MovieItemView(item, navController)
                    }
                }
            })
    }
}

@Composable
fun MovieItemView(item: Movie, navController: NavController) {
    Surface(
        modifier = Modifier
            .background(Purple200)
    ) {
        Column(
            modifier = Modifier
                .padding(5.dp)
                .background(Color.Transparent)
        ) {
            Image(painter = rememberAsyncImagePainter(ApiConstants.IMAGE_URL.plus(item.posterPath)),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(250.dp)
                    .cornerRadius6()
                    .clickable {
                        navController.navigate(Screen.MovieDetail.route.plus("/${item.id}"))
                    })

            SubtitlePrimary(text = item.title, Modifier.padding(3.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    painter = painterResource(id = R.drawable.ic_release_date),
                    contentDescription = null,
                    Modifier.size(30.dp)
                )
                SubtitleSecondary(
                    text = item.releaseDate,
                    Modifier.fillMaxHeight()
                )
            }
        }
    }
}

fun <T : Any> LazyGridScope.items(
    lazyPagingItems: LazyPagingItems<T>,
    itemContent: @Composable LazyGridItemScope.(value: T?) -> Unit
) {
    items(lazyPagingItems.itemCount) { index ->
        itemContent(lazyPagingItems[index])
    }
}
