package com.movie.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.movie.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> { 

	 @Query("SELECT m from Movie m where m.isDeleted =false")
	 List<Movie> getAllMovies();
}
