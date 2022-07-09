package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import com.example.demo.dto.Actor;
import com.example.demo.dto.Movie;
import com.example.demo.service.MovieService;

@Controller
@CrossOrigin
@RequestMapping("/actors")
public class ActorController {
	@Autowired
	private MovieService movieService;

	@GetMapping
	@ResponseBody
	public CollectionModel<Actor> getAllActors() {
		List<Actor> listActor = movieService.getAllActor();

		for (Actor actor : listActor) {
			if (!actor.hasLinks()) {
				Link moviesLink = linkTo(methodOn(ActorController.class).getMoviesForActor(actor.getName()))
						.withRel("allMovies");
				actor.add(moviesLink);
			}
		}

		Link link = linkTo(ActorController.class).withSelfRel();
		CollectionModel<Actor> result = CollectionModel.of(listActor, link);
		return result;
	}

	@GetMapping(value = "/{actorName}/movies")
	@ResponseBody
	public CollectionModel<Movie> getMoviesForActor(@PathVariable String actorName) {
		List<Movie> listMovie = movieService.getAllMovieByActor(actorName);

		for (Movie movie : listMovie) {
			if (!movie.hasLinks()) {
				Link selfLink = linkTo(methodOn(ActorController.class).getMovieByName(actorName, movie.getName()))
						.withSelfRel();
				movie.add(selfLink);
			}
		}

		Link link = linkTo(methodOn(ActorController.class).getMoviesForActor(actorName)).withSelfRel();
		CollectionModel<Movie> result = CollectionModel.of(listMovie, link);
		return result;
	}

	@ResponseBody
	@GetMapping("/{actorName}/{movieName}")
	public Movie getMovieByName(@PathVariable String actorName, @PathVariable String movieName) {
		List<Movie> listMovie = movieService.getAllMovieByActor(actorName);
		Movie movieByName = null;
		for (Movie movie : listMovie) {
			if (movie.getName().equals(movieName)) {
				movieByName = movie;
			}

		}

		return movieByName;
	}
}
