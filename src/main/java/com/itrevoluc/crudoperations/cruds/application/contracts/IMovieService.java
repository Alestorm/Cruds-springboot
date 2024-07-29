package com.itrevoluc.crudoperations.cruds.application.contracts;

import com.itrevoluc.crudoperations.cruds.domain.entities.Movie;

import java.util.List;

public interface IMovieService {
    Movie saveMovie(Movie movie);

    Movie getMovie(long idMovie);

    List<Movie> getMovies();

    void editMovie(Movie updateMovie, long idMovie);

    void deleteMovie(long idMovie);
    List<Movie> searchMovies(String title);
}