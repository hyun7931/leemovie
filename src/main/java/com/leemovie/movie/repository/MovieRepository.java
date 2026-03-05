package com.leemovie.movie.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.leemovie.movie.domain.Movie;

@Repository
public class MovieRepository {

    private final List<Movie> movies = new ArrayList<>(List.of(
            new Movie(
                    1L,
                    "왕과 사는 남자",
                    "/images/image1.webp",
                    4.5,
                    120000,
                    "왕과 함께 살아가는 남자의 이야기"
            ),
            new Movie(
                    2L,
                    "호퍼스",
                    "/images/image2.jpg",
                    4.2,
                    98000,
                    "예상치 못한 사건에 휘말리는 이야기"
            ),
            new Movie(
                    3L,
                    "휴민트",
                    "/images/image3.webp",
                    4.7,
                    150000,
                    "정보전과 첩보를 다루는 스릴러"
            ),
            new Movie(
                    4L,
                    "우리는 매일매일",
                    "/images/image4.avif",
                    4.3,
                    87000,
                    "평범한 일상 속 특별한 이야기"
            ),
            new Movie(
                    5L,
                    "너자2",
                    "/images/image5.webp",
                    4.8,
                    210000,
                    "전설 속 캐릭터의 새로운 모험"
            ),
            new Movie(
                    6L,
                    "햄넷",
                    "/images/image6.webp",
                    4.4,
                    93000,
                    "셰익스피어 가족의 이야기를 다룬 감성 드라마"
            ),
            new Movie(
                    7L,
                    "신의 악단",
                    "/images/image7.webp",
                    4.1,
                    76000,
                    "음악으로 세상을 바꾸는 사람들의 이야기"
            ),
            new Movie(
                    8L,
                    "굿 윌 헌팅",
                    "/images/image8.webp",
                    4.9,
                    130000,
                    "천재 청년과 심리학자의 성장 이야기"
            ),
            new Movie(
                    9L,
                    "초속 5센티미터",
                    "/images/image9.webp",
                    4.6,
                    115000,
                    "시간과 거리 속에서 멀어지는 두 사람의 이야기"
            ),
            new Movie(
                    10L,
                    "주토피아2",
                    "/images/image10.webp",
                    4.3,
                    168000,
                    "동물 도시에서 벌어지는 새로운 모험"
            )
    ));

    public List<Movie> findAll() {
        return movies;
    }

    public Optional<Movie> findById(Long id) {
        return movies.stream().filter(m -> m.getMovieId().equals(id)).findFirst();
    }
}