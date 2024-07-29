package com.itrevoluc.crudoperations.cruds.presentation;

import com.itrevoluc.crudoperations.cruds.application.contracts.IMovieService;
import com.itrevoluc.crudoperations.cruds.domain.entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173/")
@RequestMapping("/api/movies")
public class MovieController {
    @Autowired
    private IMovieService _movieService;

    @PostMapping
    public ResponseEntity<Movie> SaveMovie(@RequestBody Movie movie) {
        return new ResponseEntity<>(_movieService.saveMovie(movie), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Movie>> GetMovies() {
        return new ResponseEntity<>(_movieService.getMovies(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> GetMovie(@PathVariable long id) {
        var movie = _movieService.getMovie(id);
        if (movie == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Movie>> GetMoviesByTitle(@RequestParam(name = "title") String title) {
        return new ResponseEntity<>(_movieService.searchMovies(title), HttpStatus.OK);
    }
}