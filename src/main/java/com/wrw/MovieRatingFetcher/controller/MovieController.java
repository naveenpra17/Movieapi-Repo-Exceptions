package com.wrw.MovieRatingFetcher.controller;

import com.wrw.MovieRatingFetcher.domain.Movie;
import com.wrw.MovieRatingFetcher.exceptions.MovieNotFoundException;
import com.wrw.MovieRatingFetcher.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1")
public class MovieController {

    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);

    private MovieService movieService;
    private Environment environment;

    @Autowired
    public MovieController(MovieService movieService, Environment environment) {
        this.movieService = movieService;
        this.environment = environment;
    }

    @GetMapping("movie/{movieName}")
    public Mono<Movie>getMovieByTitle(@PathVariable String movieName) throws Exception, MovieNotFoundException {
        String apiKey = environment.getProperty("app.api.key");
//        System.out.println(movieName);
        return movieService.searchMovieByTitle(apiKey,movieName);
    }
}
