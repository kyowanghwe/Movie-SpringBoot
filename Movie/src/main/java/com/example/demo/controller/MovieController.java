package com.example.demo.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class MovieController {
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

}
