package com.example.demo.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.demo.dto.Actor;
import com.example.demo.dto.Movie;

@Service
public class MovieService {
	@Autowired
	private Environment env;

	public List<String> getMp4FileName(String path) {
		List<String> results = new ArrayList<String>();

		File[] files = new File(path).listFiles();
		// If this pathname does not denote a directory, then listFiles() returns null.
		if (!ObjectUtils.isEmpty(files)) {
			for (File file : files) {
				if (file.isFile()) {
					if (file.getName().endsWith(".mp4"))
						results.add(file.getName().replaceAll(".mp4", ""));
				}
			}
		}

		return results;
	}

	public List<String> getAllSubFolderName(String path) {
		List<String> results = new ArrayList<String>();

		File[] files = new File(path).listFiles();
		// If this pathname does not denote a directory, then listFiles() returns null.

		if (!ObjectUtils.isEmpty(files)) {
			for (File file : files) {
				if (file.isDirectory()) {
					results.add(file.getName());
				}
			}
		}

		return results;
	}

	public List<Actor> getAllActor() {
		List<Actor> listActor = new ArrayList<>();
		getAllSubFolderName(env.getProperty("config.folderPath")).forEach(actorName -> {
			Actor actor = new Actor(actorName);
			listActor.add(actor);
		});

		return listActor;
	}

	public List<Movie> getAllMovieByActor(String actorName) {
		List<Movie> listMovie = new ArrayList<>();
		getMp4FileName(env.getProperty("config.folderPath") + "/" + actorName).forEach(movieName -> {
			Movie movie = new Movie(movieName, null);
			listMovie.add(movie);
		});

		return listMovie;
	}
}
