# Movies 

This is a simple android application that uses TheMovieDB API to show the trending movies and their details.

What's been used: 

1.MVVM architecture 
2.Hilt for dependency injection 
3.OkHttp/Retrofit 
4.Kotlin Flow 
5.Room 
6.Jetpack Compose 
7.Coroutines 
8.Navigation Component 
9.JUnit

The application has two screens:

    Trending Movies screen (https://api.themoviedb.org/3/discover/movie)
    Movie details screen (https://developers.themoviedb.org/3/movies/{movie_id})

The application has 3 main packages:

    data layer : all the components related to data such as data sources, repositories, data-states, database.
    domain layer: this is the business logic classes such as the use cases and the models.
    ui layer: all the UI related classes such as fragments, view models and compose components.


Testing strategy: 
Unit tests on the domain layer using JUnit. Simple tests implemented on the data layer to test the Dao.
