package com.leemovie.movie.domain;

public class Review {
    private Long movieId;
    private String author;
    private String content;
    private double rating;

    public Review(Long movieId, String author, String content, double rating) {
        this.movieId = movieId;
        this.author = author;
        this.content = content;
        this.rating = rating;
    }

    public Long getMovieId() { return movieId; }
    public String getAuthor() { return author; }
    public String getContent() { return content; }
    public double getRating() { return rating; }
}