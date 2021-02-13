package com.microserviceone.microserviceone.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.microserviceone.microserviceone.bean.CatlogItem;
import com.microserviceone.microserviceone.bean.MovieItem;
import com.microserviceone.microserviceone.bean.UserRating;

@RestController
@RequestMapping("/catlog")
public class MovieCatlogController {
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient.Builder webClientbuilder;
	
	@RequestMapping("/{userId}")
	public List<CatlogItem> getCatlog(@PathVariable("userId")	String userId){
	//	RestTemplate restTemplate = new RestTemplate();
	//	WebClient.Builder builder = WebClient.builder();
//		List<RatingData> ratingData = Arrays.asList(
//				new RatingData("1", 4),
//				new RatingData("2", 3));
		
		UserRating userRating = restTemplate.getForObject("http://microservice-three-rating-info/rating/users/"+userId, UserRating.class);
		
	return	userRating.getUserRating().stream().map(rating -> {
		MovieItem movieItem = restTemplate.getForObject("http://microservice-two-movie-info/movie/"+rating.getMovieId(), MovieItem.class);
		
//		MovieItem movieItem = webClientbuilder.build()
//				.get()
//				.uri("http://localhost:8200/movie/"+rating.getMovieId())
//				.retrieve()
//				.bodyToMono(MovieItem.class)
//				.block();
//				
				
			return new CatlogItem(movieItem.getMovieName(), "good", rating.getRating());
		})
		.collect(Collectors.toList());
		
//		return Collections.singletonList(new CatlogItem("gokul", "maara", 4));
	}

}
