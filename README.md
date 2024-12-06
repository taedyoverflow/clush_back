# ToDo API Project

## 프로젝트 설명
이 프로젝트는 **Spring Boot**를 사용하여 개발된 **할 일(ToDo) 관리 API**입니다. 기본 CRUD 기능과 추가 기능(API)을 포함하며, 프론트엔드와 통신하기 위한 RESTful 서비스를 제공합니다.

---

## 주요 기능

1. **CRUD API**:
   - 작업(Task)의 생성(Create), 조회(Read), 수정(Update), 삭제(Delete) 기능.
2. **추가 기능**:
   - 작업 완료 상태 업데이트 API (`PUT /api/tasks/{id}/complete`).
   - 완료된 작업만 필터링하여 조회 API (`GET /api/tasks/completed`).

---

## 요구사항
- Java 17 이상
- Gradle
- MySQL 데이터베이스
