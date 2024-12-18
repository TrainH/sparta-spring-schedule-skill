# 일정 관리 서버 (spring-schedule-skill)

##  개요
이 프로그램은 사용자의 일정을 체계적으로 관리할 수 있도록 설계된 일정 관리 서버입니다. 

일정 관리 API는 일정 관리를 위해 일정 생성, 전체 및 조건 조회, 삭제를 할 수 있습니다.

그리고 예외 처리 기능을 통해 안정성을 제공합니다.

>
> 
> **일정 관리 앱을 구현하기 위해 IntelliJ에서 Spring으로 만들어진 기본 프로젝트입니다.**
> 
> **작성자:** TrainH
> 
> **개발 기간:** 2024년 11월 29일 ~ 12월 11일  
>
> **개발 환경:**
> - **IDE**: IntelliJ IDEA
> - **프레임워크**: Spring Boot
> - **DB**: My Sql Database
>

# ERD
![image](https://github.com/user-attachments/assets/62bbfa8b-16a4-44e4-96b6-8f795baa5c15)


# 포스트맨 API 상세 명세서
>
> https://documenter.getpostman.com/view/30208126/2sAYJ1kh9o 
>


# API 명세서 요약 (spring-schedule-skill)

### 기본 URL

`http://localhost:8080`

---


### 1. 일정 관리 (Schedule)

| 기능          | URL                 | Method | Request Body                                                                                      | Response                          |
|---------------|---------------------|--------|--------------------------------------------------------------------------------------------------|-----------------------------------|
| 일정 등록     | `/schedules`        | POST   | `{ "userName": "사용자 이름", "todoTitle": "할 일 제목", "todoContent": "할 일 내용" }`          | 200 OK / 401 Unauthorized / 404 Not Found |
| 일정 조회     | `/schedules`        | GET    | -                                                                                                | 200 OK / 401 Unauthorized         |
| 페이지 일정 조회| `/schedules/list?page={page}`   | GET    | -                                                                                                | 200 OK / 401 Unauthorized / 404 Not Found |
| 단일 일정 조회| `/schedules/{id}`   | GET    | -                                                                                                | 200 OK / 401 Unauthorized / 404 Not Found |
| 일정 수정     | `/schedules/{id}`   | PATCH  | `{ "todoTitle": "수정된 제목", "todoContent": "수정된 내용" }`                                | 200 OK / 401 Unauthorized / 404 Not Found |
| 일정 삭제     | `/schedules/{id}`   | DELETE | -                                                                                                | 200 OK / 401 Unauthorized / 404 Not Found |

---

### 2. 유저 관리 (Member)

| 기능          | URL                 | Method | Request Body                                                                                      | Response                          |
|---------------|---------------------|--------|--------------------------------------------------------------------------------------------------|-----------------------------------|
| 유저 등록   | `/members/signup`   | POST   | `{ "userName": "사용자 이름", "email": "이메일 주소", "password": "비밀번호" }`                 | 200 OK / 400 Bad Request          |
| 유저 목록 조회| `/members`         | GET    | -                                                                                                | 200 OK / 401 Unauthorized         |
| 단일 유저 조회| `/members/{id}`    | GET    | -                                                                                                | 200 OK / 401 Unauthorized / 404 Not Found |
| 유저 수정   | `/members/{id}`     | PATCH  | `{ "userName": "수정된 이름", "password": "수정된 비밀번호" }`                                | 200 OK / 401 Unauthorized / 404 Not Found |
| 유저 삭제   | `/members/{id}`     | DELETE | -                                                                                                | 200 OK / 401 Unauthorized / 404 Not Found |

---

### 3. 로그인, 인증 (Authentication)

| 기능          | URL                 | Method | Request Body                                                                                      | Response                          |
|---------------|---------------------|--------|--------------------------------------------------------------------------------------------------|-----------------------------------|
| 로그인        | `/auth/login`       | POST   | `{ "email": "이메일 주소", "password": "비밀번호" }`                                         | 200 OK / 404 Not Found            |
| 로그아웃      | `/auth/logout`      | POST   | -                                                                                                | 200 OK                             |

---

### 4. 댓글 관리 (Comment)

| 기능          | URL                 | Method | Request Body                                                                                      | Response                          |
|---------------|---------------------|--------|--------------------------------------------------------------------------------------------------|-----------------------------------|
| 댓글 등록     | `/comments`         | POST   | `{ "schedule_id": "일정 ID", "comment": "댓글 내용" }`                                       | 200 OK / 401 Unauthorized         |
| 댓글 목록 조회| `/comments`         | GET    | -                                                                                                | 200 OK / 401 Unauthorized         |
| 단일 댓글 조회| `/comments/{id}`    | GET    | -                                                                                                | 200 OK / 401 Unauthorized / 404 Not Found |
| 댓글 수정| `/comments/{id}`    | PATCH    | -                                                                                                | 200 OK / 401 Unauthorized / 404 Not Found |
| 댓글 삭제| `/comments/{id}`    | DELETE    | -                                                                                                | 200 OK / 401 Unauthorized / 404 Not Found |
---
