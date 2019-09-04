package com.wrw.MovieRatingFetcher.service;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.Duration;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovieServiceImplTest {

  @Autowired
  private WebTestClient webTestClient;

  @Before
  public void setUp(){
    webTestClient=webTestClient.mutate().responseTimeout(Duration.ofMillis(360000)).build();
  }
  @Test
  public void searchMovieByTitle() {
    webTestClient.get()
      .uri("/api/v1/movie//{name}", "Superman")
      .exchange()
      .expectStatus().isOk()
      .expectBody()
      .consumeWith(response ->
        Assertions.assertThat(response.getResponseBody()).isNotNull());
  }

  @Test
  public void searchMovieByTitle1() {
    webTestClient.get()
      .uri("/api/v1/movies/{name}", "Superman")
      .exchange()
      .expectStatus().isNotFound()
      .expectBody()
      .consumeWith(response ->
        Assertions.assertThat(response.getResponseBody()).isNotNull());
  }
}
