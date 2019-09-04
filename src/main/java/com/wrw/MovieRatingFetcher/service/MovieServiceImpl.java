package com.wrw.MovieRatingFetcher.service;

import com.wrw.MovieRatingFetcher.domain.Movie;
import com.wrw.MovieRatingFetcher.exceptions.MovieNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class MovieServiceImpl implements MovieService {

    private static final String OMDB_MIME_TYPE = "application/json";
    private static final String OMDB_API_BASE_URL = "http://omdbapi.com";
    private static final String USER_AGENT = "Spring 5 WebClient";
    private static final Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);

    private final WebClient webClient;

    public MovieServiceImpl() {
        this.webClient = WebClient.builder()
                .baseUrl(OMDB_API_BASE_URL)
//                .defaultHeader(HttpHeaders.CONTENT_TYPE, OMDB_MIME_TYPE)
//                .defaultHeader(HttpHeaders.USER_AGENT, USER_AGENT)
                .build();
    }

    @Override
    public Mono<Movie> searchMovieByTitle(String apiKey, String title) throws  Exception, MovieNotFoundException {

      if( webClient.get()
        .uri("/?apikey="+apiKey+"&t="+title)
        .retrieve()
        .bodyToMono(Movie.class).toString().contains("null")) {
        return webClient.get()
          .uri("/?apikey=" + apiKey + "&t=" + title)
          .retrieve()
          .bodyToMono(Movie.class);
      }else
        throw new  MovieNotFoundException("Movie not available shailesh");
    }

//    public static void handler(Movie s){
//      System.out.println(s.getTitle());
//    }
}
