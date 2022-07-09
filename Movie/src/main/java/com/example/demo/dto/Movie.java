package com.example.demo.dto;

import java.util.List;

import org.springframework.hateoas.RepresentationModel;

public class Movie extends RepresentationModel<Movie> {
	private String name;
	private List<String> category;

	public Movie(String name, List<String> category) {
		this.name = name;
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getCategory() {
		return category;
	}

	public void setCategory(List<String> category) {
		this.category = category;
	}
}