package com.microservicetwo.microservicetwo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicetwo.microservicetwo.bean.MovieItem;

@RestController
@RequestMapping("/movie")
public class MovieController {

	@RequestMapping("/{movieId}")
	MovieItem getMovieItem(@PathVariable("movieId") String movieId) {
		return new MovieItem("1","maara");
	}
}
