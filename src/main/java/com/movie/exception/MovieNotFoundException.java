package com.movie.exception;

public class MovieNotFoundException extends Exception {
	
	private static final long serialVersionUID = -3066727756929482537L;

	public MovieNotFoundException(long movieId) {
	        super(String.format("Movie is not found, ID : '%s'", movieId));
	        }
	}