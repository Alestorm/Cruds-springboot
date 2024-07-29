package com.itrevoluc.crudoperations.cruds.application.services;

import com.itrevoluc.crudoperations.cruds.application.contracts.IMovieService;
import com.itrevoluc.crudoperations.cruds.domain.entities.Movie;
import com.itrevoluc.crudoperations.cruds.infrastructure.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMovieService {
    @Autowired
    private IMovieRepository _movieRepository;

    @Override
    public Movie saveMovie(Movie movie) {
        return _movieRepository.save(movie);
    }

    @Override
    public Movie getMovie(long idMovie) {
        return _movieRepository.findById(idMovie).orElse(null);
    }

    @Override
    public List<Movie> getMovies() {
        return _movieRepository.findAll();
    }

    @Override
    public void editMovie(Movie updateMovie, long idMovie) {

    }

    @Override
    public void deleteMovie(long idMovie) {
        _movieRepository.findById(idMovie).ifPresent(movie -> _movieRepository.delete(movie));
    }

    @Override
    public List<Movie> searchMovies(String title) {
        return _movieRepository.findMovieByTitle(title);
    }
}
