package com.leemovie.movie.domain;

public class Movie {
    private Long movieId;
    private String title;
    private String imageUrl;
    private double rating;
    private int audience;

    private String description; // 상세에서 씀

    public Movie(Long movieId, String title, String imageUrl, double rating, int audience, String description) {
        this.movieId = movieId;
        this.title = title;
        this.imageUrl = imageUrl;
        this.rating = rating;
        this.audience = audience;
        this.description = description;
    }

    public Long getMovieId() { return movieId; }
    public String getTitle() { return title; }
    public String getImageUrl() { return imageUrl; }
    public double getRating() { return rating; }
    public int getAudience() { return audience; }
    public String getDescription() { return description; }
}