# LeeMovie 영화 정보 프로젝트

## 개요

**LeeMovie**는 영화 정보 조회 및 리뷰 관리를 할 수 있는 Spring Boot 기반 웹 애플리케이션입니다.  
영화 목록 조회, 영화 상세 정보 확인, 그리고 영화별 리뷰 작성 및 조회 기능을 제공합니다.

---

## 프로젝트 구조

```
src/main/java/com/leemovie/movie/
├── MovieApplication.java          # Spring Boot 애플리케이션 진입점
├── controller/                    # 웹 요청 처리
│   ├── MovieController.java       # 영화 목록 조회 엔드포인트
│   └── ReviewController.java      # 영화 상세 및 리뷰 관리 엔드포인트
├── service/                       # 비즈니스 로직 계층
│   ├── MovieService.java          # 영화 데이터 처리 로직
│   └── ReviewService.java         # 리뷰 데이터 처리 로직
├── repository/                    # 데이터 접근 계층
│   ├── MovieRepository.java       # 영화 데이터 저장소 (10개 샘플 데이터 포함)
│   └── ReviewRepository.java      # 리뷰 데이터 저장소
└── domain/                        # 데이터 모델
    ├── Movie.java                 # 영화 엔티티
    └── Review.java                # 리뷰 엔티티

src/main/resources/
├── templates/                     # Thymeleaf HTML 템플릿
│   ├── movie-list.html            # 영화 목록 화면
│   └── movie-detail.html          # 영화 상세 및 리뷰 화면
└── static/                        # 정적 리소스
    ├── movieStyle.css             # 영화 목록 스타일
    ├── movieDetailStyle.css       # 상세화면 스타일
    └── images/                    # 영화 포스터 이미지
```

---

## 기능

### 1. 영화 목록 조회
- **엔드포인트**: `GET /movies`
- **설명**: 시스템에 등록된 모든 영화의 목록을 조회합니다.
- **화면**: `movie-list.html`에서 영화 카드 형식으로 표시
- **표시 정보**: 영화 제목, 포스터 이미지, 평점, 관객 수

### 2. 영화 상세 조회
- **엔드포인트**: `GET /movies/{id}`
- **설명**: 특정 영화의 상세 정보를 조회합니다.
- **화면**: `movie-detail.html`에서 표시
- **표시 정보**: 제목, 이미지, 평점, 관객 수, 상세 설명

### 3. 영화별 리뷰 조회
- **엔드포인트**: `GET /movies/{id}`에 포함
- **설명**: 특정 영화의 모든 리뷰를 조회합니다.
- **표시 정보**: 리뷰 작가, 내용, 평점

### 4. 리뷰 작성
- **엔드포인트**: `POST /movies/{id}/reviews`
- **요청 파라미터**:
  - `author`: 리뷰 작가 (String)
  - `content`: 리뷰 내용 (String)
  - `rating`: 평점 (double)
- **설명**: 특정 영화에 새로운 리뷰를 추가합니다.
- **응답**: 리뷰 작성 후 해당 영화 상세 페이지로 리다이렉트

---

## 데이터 모델

### Movie (영화)
```java
- movieId (Long)      : 영화 고유 ID
- title (String)      : 영화 제목
- imageUrl (String)   : 포스터 이미지 URL
- rating (double)     : 평점 (0.0 ~ 5.0)
- audience (int)      : 관객 수
- description (String): 상세 설명
```

### Review (리뷰)
```java
- movieId (Long)   : 영화 ID (외래키)
- author (String)  : 리뷰 작가
- content (String) : 리뷰 내용
- rating (double)  : 평점 (0.0 ~ 5.0)
```

---

## 기술 스택

- **Framework**: Spring Boot
- **Language**: Java
- **Template Engine**: Thymeleaf
- **Build Tool**: Gradle
- **Web Standard**: HTML5, CSS3

---

## 실행 방법

### 1. 프로젝트 빌드
```bash
./gradlew build
```

### 2. 애플리케이션 실행
```bash
./gradlew bootRun
```

### 3. 웹 브라우저에서 접속
```
http://localhost:8080/movies
```

---

## 주요 클래스 설명

### MovieController
- `movieList()`: 영화 목록 페이지를 제공합니다.

### ReviewController
- `detail()`: 영화 상세 정보와 리뷰 목록을 제공합니다.
- `addReview()`: 새로운 리뷰를 시스템에 저장합니다.

### MovieService
- `getMovies()`: 모든 영화 목록을 반환합니다.
- `getMovieById()`: 특정 ID의 영화 정보를 반환합니다.

### ReviewService
- `getReviewsByMovieId()`: 특정 영화의 모든 리뷰를 반환합니다.
- `addReview()`: 새로운 리뷰를 저장합니다.
