package com.wrw.MovieRatingFetcher.service;

import com.wrw.MovieRatingFetcher.domain.Movie;
import com.wrw.MovieRatingFetcher.exceptions.MovieNotFoundException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

public interface MovieService {

    public Mono<Movie> searchMovieByTitle(String apiKey, String title) throws Exception, MovieNotFoundException;
}
