package com.leemovie.movie.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.leemovie.movie.domain.Movie;
import com.leemovie.movie.service.MovieService;

@Controller
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public String movieList(Model model) {

        List<Movie> movies = movieService.getMovies();

        model.addAttribute("movies", movies);

        return "movie-list";
    }
}