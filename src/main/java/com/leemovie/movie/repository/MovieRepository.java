package com.leemovie.movie.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.leemovie.movie.domain.Movie;

@Repository
public class MovieRepository {

    private final List<Movie> movies = new ArrayList<>(List.of(
            new Movie(1L, "Interstellar", "/images/interstellar.jpg", 4.8, 1200000, "우주를 배경으로 한 SF 명작"),
            new Movie(2L, "Inception", "/images/inception.jpg", 4.6, 980000, "꿈 속의 꿈을 다루는 액션/스릴러"),
            new Movie(3L, "Avengers", "/images/avengers.jpg", 4.3, 1500000, "히어로들이 한 팀으로!")
    ));

    public List<Movie> findAll() {
        return movies;
    }

    public Optional<Movie> findById(Long id) {
        return movies.stream().filter(m -> m.getMovieId().equals(id)).findFirst();
    }
}