package com.example.demo.dto;

import org.springframework.hateoas.RepresentationModel;

public class Actor extends RepresentationModel<Actor> {
	private String name;

	public Actor(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
