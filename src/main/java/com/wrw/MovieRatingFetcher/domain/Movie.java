package com.wrw.MovieRatingFetcher.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.websocket.server.ServerEndpoint;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Movie {
  @JsonProperty("Title")
    private String Title;
  @JsonProperty("Plot")
  private String description;
  @JsonProperty("Poster")
  private String img;
  @JsonProperty("imdbRating")
  private String imdbRating;
  @JsonProperty("Genre")
  private String genre;
  @JsonProperty("imdbVotes")
  private String imdbVotes;
}
