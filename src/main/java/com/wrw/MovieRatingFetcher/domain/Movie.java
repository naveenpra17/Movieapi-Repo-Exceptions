package com.wrw.MovieRatingFetcher.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
