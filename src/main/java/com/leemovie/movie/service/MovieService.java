package com.leemovie.movie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.leemovie.movie.domain.Movie;
import com.leemovie.movie.repository.MovieRepository;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 영화가 없습니다. id=" + id));

    }
}