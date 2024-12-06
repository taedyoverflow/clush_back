# ToDo API Project

## 프로젝트 설명
이 프로젝트는 Clush 개발자 채용 관련 과제 제출을 위하여 **Spring Boot**를 사용하여 개발된 **할 일(ToDo) 관리 API**입니다.  
기본 CRUD 기능 외에도 추가적인 API를 구현했으며, MySQL을 활용한 데이터 저장 및 Swagger를 통한 API 명세 제공, 테스트 케이스를 작성하여 검증을 완료했습니다.

---

## 주요 기능

1. **CRUD API**:
   - 작업(Task)의 생성(Create), 조회(Read), 수정(Update), 삭제(Delete) 기능.
2. **추가 기능**:
   - **작업 완료 상태 업데이트**: 특정 작업의 완료 여부를 업데이트 (`PUT /api/tasks/{id}/complete`).
   - **완료된 작업 조회**: 완료된 작업만 필터링하여 조회 (`GET /api/tasks/completed`).

---

## 요구사항
- Java 17 이상
- Gradle
- MySQL 데이터베이스

---

## 1. 자신이 개발한 앱에 대한 설명

### 기술 스택
- **Backend**: Spring Boot 3.1.4, Spring Data JPA, Lombok
- **Database**: MySQL
- **API Documentation**: SpringDoc OpenAPI(Swagger UI)
- **Testing**: JUnit 5, Mockito

### 주요 목적
- **할 일 관리 시스템**:
  - 작업 추가, 수정, 삭제, 조회 및 완료 상태 관리.
  - 완료된 작업만 필터링하여 조회하는 기능 추가.
- **확장 가능성**:
  - 추가 기능을 쉽게 구현할 수 있도록 RESTful API 설계.

---

## 2. 소스 빌드 및 실행 방법 메뉴얼

### **2.1 데이터베이스 설정**
1. MySQL에서 데이터베이스 생성:
    ```sql
    CREATE DATABASE todo_app;
    ```
2. `src/main/resources/application.yml`에서 MySQL 접속 정보를 설정:
    ```yaml
    spring:
      datasource:
        url: jdbc:mysql://localhost:3306/todo_app
        username: <your-database-username>
        password: <your-database-password>
      jpa:
        hibernate:
          ddl-auto: update
    ```

### **2.2 프로젝트 실행**
1. **프로젝트 클론**:
    ```bash
    git clone https://github.com/<your-username>/todo-backend.git
    cd todo-backend
    ```
2. **의존성 설치 및 실행**:
    ```bash
    ./gradlew bootRun
    ```

### **2.3 데이터베이스 초기 데이터 삽입**
테스트를 위해 초기 데이터를 삽입하려면 아래 SQL 명령어를 실행:
```sql
INSERT INTO task (name, priority, completed) VALUES ('Clush 프론트엔드 과제 제출', 'High', TRUE);
INSERT INTO task (name, priority, completed) VALUES ('Clush 백엔드 과제 제출', 'High', TRUE);
INSERT INTO task (name, priority, completed) VALUES ('다이어트', 'Low', FALSE);

3. 주력으로 사용한 라이브러리에 대한 설명 및 사용 이유
Spring Boot Starter Web:
RESTful API 개발에 필요한 기본 기능 제공.
Spring Boot Starter Data JPA:
데이터베이스와의 통합 및 CRUD 작업 간소화.
Lombok:
반복적인 Getter, Setter 및 Constructor 생성을 줄여 코드 가독성 향상.
SpringDoc OpenAPI(Swagger UI):
API 명세를 자동으로 생성하고, 테스트할 수 있는 UI 제공.
Spring Boot Starter Test:
JUnit 및 Mockito를 사용한 단위 테스트 및 통합 테스트 지원.
4. API 명세
Swagger UI를 통해 API 명세를 확인할 수 있습니다:

주소: http://localhost:8080/swagger-ui.html
API 스크린샷

5. 테스트 케이스 작성 및 결과
테스트 환경
JUnit 5 및 Mockito를 사용하여 테스트 케이스 작성.
주요 API 테스트:
작업 추가, 수정, 삭제 테스트.
완료 상태 업데이트 테스트.
완료된 작업 조회 테스트.
실행 방법
Gradle로 테스트 실행:

bash
코드 복사
./gradlew test
테스트 결과
총 테스트 케이스: 5개
성공한 테스트 케이스: 5개
실패한 테스트 케이스: 0개
테스트 리포트는 다음 경로에서 확인 가능합니다:

bash
코드 복사
build/reports/tests/test/index.html
6. 추가 기능 API 구현
추가 기능
작업 완료 상태 업데이트:

API 엔드포인트: PUT /api/tasks/{id}/complete
완료 상태를 true 또는 false로 변경.
프론트엔드에서 체크박스를 통해 완료 상태를 관리.
완료된 작업 조회:

API 엔드포인트: GET /api/tasks/completed
완료된 작업만 필터링하여 반환.
7. 데이터베이스 스키마 및 초기 데이터
데이터베이스 스키마
sql
코드 복사
CREATE TABLE task (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    priority VARCHAR(50) NOT NULL,
    completed BOOLEAN DEFAULT FALSE
);
초기 데이터 삽입
sql
코드 복사
INSERT INTO task (name, priority, completed) VALUES ('Clush 프론트엔드 과제 제출', 'High', TRUE);
INSERT INTO task (name, priority, completed) VALUES ('Clush 백엔드 과제 제출', 'High', TRUE);
INSERT INTO task (name, priority, completed) VALUES ('다이어트', 'Low', FALSE);
과제 요구사항 체크리스트
 기본 CRUD API 구현
 Swagger를 통한 API 명세 제공
 테스트 케이스 작성 및 통과
 추가 API 구현 (PUT /complete, GET /completed)
 MySQL 연동 및 DB 스키마 제공
