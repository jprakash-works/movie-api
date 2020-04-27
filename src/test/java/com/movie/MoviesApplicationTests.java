package com.movie;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.movie.dao.MovieRepository;
import com.movie.exception.MovieNotFoundException;
import com.movie.model.Movie;
import com.movie.service.MovieService;



@SpringBootTest
public class MoviesApplicationTests {

	MovieService movieService;

	MovieRepository movieDao;

	@Before
	public void setUp() {
		movieDao =  Mockito.mock(MovieRepository.class);
		movieService = new MovieService();
		movieService.setMovieDao(movieDao);
	}
	
	
	@Test
	public void addTest() {
		Movie movie = new Movie();
		movie.setCategory("Test Category");
		movie.setRating(2d);
		movie.setIsDeleted(false);
		movie.setTitle("Movie Title");
		when(movieDao.save(movie)).thenReturn(movie);
		Movie result = null;
		result = movieService.add(movie);
		assertNotNull(result);
	}
	
	

	@Test
	public void editTest() throws MovieNotFoundException {
		Movie movie = new Movie();
		movie.setId(2l);
		movie.setIsDeleted(false);
		movie.setCategory("Test Category");
		movie.setRating(2d);
		movie.setTitle("Test Title");
		when(movieDao.findById(2l)).thenReturn(Optional.of(movie));
		
		// Changing rating & category
		movie.setRating(4d);
		movie.setCategory("Edited Category");
		when(movieDao.save(movie)).thenReturn(movie);
		
		Movie result = movieService.edit(movie);
		assertEquals(Double.valueOf(4), result.getRating());
		assertEquals("Edited Category", result.getCategory());
	}

	

	@Test
	public void getMovieByIdTest() throws MovieNotFoundException {
		Movie movie = new Movie();
		movie.setCategory("Category");
		movie.setRating(3d);
		movie.setIsDeleted(false);
		movie.setTitle("Title");
		movie.setId(2l);
		when(movieDao.findById(2l)).thenReturn(Optional.of(movie));
		movie = movieService.find(2l);
		assertNotNull(movie);
	}

	@Test
	public void deleteTest() throws MovieNotFoundException {
		Movie movie = new Movie();
		movie.setCategory("Category");
		movie.setRating(3d);
		movie.setIsDeleted(false);
		movie.setTitle("Title");
		movie.setId(2l);
		when(movieDao.findById(2l)).thenReturn(Optional.of(movie));
		movieService.delete(2l);
		
		
		Movie result = movieService.find(2l);
		assertEquals(true, result.getIsDeleted());
	}

	@Test(expected = MovieNotFoundException.class)
	public void deleteMovieExceptionTest() throws MovieNotFoundException {
		when(movieDao.findById(2l)).thenReturn(Optional.empty());
		movieService.delete(2l);
	}
}
