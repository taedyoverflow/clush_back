# ToDo API Project - Backend

## 프로젝트 설명
이 프로젝트는 Spring Boot를 사용하여 개발된 **할 일(ToDo) 관리 API**입니다.  
기본 CRUD API와 함께, 추가 기능으로 작업 완료 상태 업데이트 및 완료된 작업 필터링 API를 제공합니다.  
MySQL을 데이터 저장소로 사용하며, Swagger UI를 통해 API 명세를 확인할 수 있습니다.

---

## 주요 기능

1. **CRUD API**:
   - 작업(Task)의 생성(Create), 조회(Read), 수정(Update), 삭제(Delete).
2. **추가 기능**:
   - 작업 완료 상태 업데이트 (`PUT /api/tasks/{id}/complete`).
   - 완료된 작업만 조회 (`GET /api/tasks/completed`).

---

## 1. 소스 빌드 및 실행 방법 메뉴얼

### 데이터베이스 설정
1. MySQL에서 데이터베이스 생성:
    ```sql
    CREATE DATABASE todo_app;
    ```
2. `application.yml`에서 MySQL 접속 정보 설정:
    ```yaml
    spring:
      datasource:
        url: jdbc:mysql://localhost:3306/todo_app
        username: <username>
        password: <password>
      jpa:
        hibernate:
          ddl-auto: update
    ```

### 실행 방법
1. 프로젝트 클론:
    ```bash
    git clone <repository-url>
    cd <repository-folder>
    ```
2. 빌드 및 실행:
    ```bash
    ./gradlew bootRun
    ```

---

## 2. 주력으로 사용한 라이브러리에 대한 설명 및 사용 이유

1. **Spring Boot Starter Web**: RESTful API 개발에 필요한 기본 기능 제공.
2. **Spring Boot Starter Data JPA**: 데이터베이스와의 통합 및 CRUD 작업 간소화.
3. **Lombok**: 코드 가독성 향상을 위한 Getter, Setter, Constructor 자동 생성.
4. **SpringDoc OpenAPI (Swagger UI)**: API 명세를 자동 생성하고, 테스트할 수 있는 UI 제공.
5. **Spring Boot Starter Test**: JUnit과 Mockito를 사용한 단위 및 통합 테스트 지원.

---

## 3. API 명세

Swagger UI를 통해 API 명세를 확인할 수 있습니다:
- **주소**: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

### API 스크린샷
![Swagger UI]([<API-IMAGE-URL](https://drive.google.com/file/d/1ds6bgaz5drd41kL9C7p6xfiyirN6eFm9/view?usp=drive_link)>)

---

## 4. 테스트케이스 작성 및 결과

### 테스트 환경
- JUnit 5 및 Mockito를 사용하여 테스트 케이스 작성.
- CRUD 및 추가 API에 대한 단위 테스트 작성 및 검증.

### 실행 방법
```bash
./gradlew test
