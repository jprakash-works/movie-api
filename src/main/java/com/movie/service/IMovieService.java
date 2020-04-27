package com.movie.service;

import java.util.List;

import com.movie.exception.MovieNotFoundException;
import com.movie.model.Movie;

public interface IMovieService {

	public Movie find(long id) throws MovieNotFoundException;
	public List<Movie> getAllMovies();
	
	public Movie add(Movie movie);
	public Movie edit(Movie movie) throws MovieNotFoundException;
	public void delete(long id) throws MovieNotFoundException;
}
