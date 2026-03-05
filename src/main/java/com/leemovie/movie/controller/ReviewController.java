package com.leemovie.movie.controller;

import com.leemovie.movie.domain.Review;
import com.leemovie.movie.service.MovieService;
import com.leemovie.movie.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/movies")
public class ReviewController {

    private final MovieService movieService;
    private final ReviewService reviewService;

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("movie", movieService.getMovieById(id));
        model.addAttribute("reviews", reviewService.getReviewsByMovieId(id));

        return "movie-detail";
    }

    @PostMapping("/{id}/reviews")
    public String addReview(@PathVariable("id") Long movieId,
                            @RequestParam String author,
                            @RequestParam String content,
                            @RequestParam double rating) {

        Review review = Review.builder()
                .movieId(movieId)
                .author(author)
                .content(content)
                .rating(rating)
                .build();

        reviewService.addReview(review);
        return "redirect:/movies/" + movieId;
    }
}