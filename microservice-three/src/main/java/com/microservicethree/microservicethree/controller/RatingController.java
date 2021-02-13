package com.microservicethree.microservicethree.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicethree.microservicethree.bean.RatingData;
import com.microservicethree.microservicethree.bean.UserRating;

@RestController
@RequestMapping("/rating")
public class RatingController {

	@RequestMapping("/{movieId}")
	RatingData getRating(@PathVariable("movieId") String movieId) {
		
		return new RatingData("1", 4);
	}
	
	
	@RequestMapping("users/{userId}")
	UserRating getUserRating(@PathVariable("userId") String userId) {
		List<RatingData> ratingDataList = Arrays.asList(
				new RatingData("1", 4),
				new RatingData("2", 3));
		UserRating userRating = new UserRating();
		userRating.setUserRating(ratingDataList);
		 
		return userRating;
	}
}
