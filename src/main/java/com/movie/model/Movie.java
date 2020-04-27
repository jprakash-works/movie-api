package com.movie.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "movie_master")
public class Movie {

	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String category;
	
	@Column(name = "IS_DELETED")
	private Boolean isDeleted;
	
	@NotNull
	@DecimalMax(value= "5")
	@DecimalMin(value ="0.5")
	private Double rating;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double i) {
		this.rating = i;
	}
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	
}
