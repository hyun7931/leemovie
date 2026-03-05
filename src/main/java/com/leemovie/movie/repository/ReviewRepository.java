package com.leemovie.movie.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.leemovie.movie.domain.Review;

@Repository
public class ReviewRepository {

    private final List<Review> reviews = new ArrayList<>(List.of(
            new Review(1L, "혜윤", "OST가 미쳤다…", 5.0),
            new Review(1L, "수현", "인생 영화", 4.5),
            new Review(2L, "채은", "전개가 완벽", 4.7)
    ));

    public List<Review> findByMovieId(Long movieId) {
        return reviews.stream()
                .filter(r -> r.getMovieId() != null && r.getMovieId().equals(movieId))
                .collect(Collectors.toList());
    }

    public void save(Review review) {
        reviews.add(review);
    }
}