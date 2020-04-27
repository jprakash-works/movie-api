package com.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.dao.MovieRepository;
import com.movie.exception.MovieNotFoundException;
import com.movie.model.Movie;

@Service
public class MovieService implements IMovieService {

	@Autowired
	MovieRepository movieDao;

	@Override
	public Movie add(Movie movie) {
		movie.setIsDeleted(false);
		return movieDao.save(movie);
	}

	@Override
	public List<Movie> getAllMovies() {
		return movieDao.getAllMovies();
	}

	@Override
	public Movie find(long id) throws MovieNotFoundException {
		return movieDao.findById(id).orElseThrow(() -> new MovieNotFoundException(id));
	}

	@Override
	public Movie edit(Movie movie) throws MovieNotFoundException {
		return movieDao.save(movie);
	}

	@Override
	public void delete(long id) throws MovieNotFoundException {
		Movie movie = movieDao.findById(id).orElseThrow(() -> new MovieNotFoundException(id));
		movie.setIsDeleted(true);
		movieDao.save(movie);
	}

	//For testing
	public void setMovieDao(MovieRepository movieDao) {
		this.movieDao = movieDao;
	}

	
}
