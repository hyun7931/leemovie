package com.leemovie.movie.service;

import com.leemovie.movie.domain.Review;
import com.leemovie.movie.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public List<Review> getReviewsByMovieId(Long movieId) {
        return reviewRepository.findByMovieId(movieId);
    }

    public void addReview(Review review) {
        reviewRepository.save(review);
    }
}