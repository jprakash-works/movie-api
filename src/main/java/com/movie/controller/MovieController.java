package com.movie.controller;

import static com.movie.util.Constants.CREATE_MOVIE;
import static com.movie.util.Constants.GET_ALL_MOVIES;
import static com.movie.util.Constants.GET_MOVIE_BY_ID;
import static com.movie.util.Constants.EDIT_MOVIE;
import static com.movie.util.Constants.DELETE_MOVIE;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movie.exception.MovieNotFoundException;
import com.movie.model.Movie;
import com.movie.service.IMovieService;

@RestController
public class MovieController {

	@Autowired
	IMovieService movieService;

	// Create new Movie
	@PostMapping(value = CREATE_MOVIE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Movie create(@Valid @RequestBody Movie movie) {
		Movie result = movieService.add(movie);
		result = movieService.add(movie);
		return result;
	}

	// Retrieving all movies
	@GetMapping(value = GET_ALL_MOVIES, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Movie> getAllMovies() {
		return movieService.getAllMovies();
	}

	// Get movie by id
	@GetMapping(value = GET_MOVIE_BY_ID, produces = MediaType.APPLICATION_JSON_VALUE)
	public Movie getMovieById(@PathVariable(value = "id") Long id) throws MovieNotFoundException {
		return movieService.find(id);
	}

	// Update movie data
	@PutMapping(value = EDIT_MOVIE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Movie updateMovie(@Valid @RequestBody Movie movie) throws MovieNotFoundException {
		Movie result = movieService.edit(movie);
		return result;
	}

	// Delete a Movie
	@GetMapping(value = DELETE_MOVIE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws MovieNotFoundException {
		movieService.delete(id);
		return ResponseEntity.ok("Movie has deleted successfully!");
	}
}
