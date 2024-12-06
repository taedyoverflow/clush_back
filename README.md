# ToDo API Project - Backend

## 프로젝트 설명
이 프로젝트는 Clush 개발자 채용을 위한 백엔드 과제 제출을 위하여 Spring Boot를 사용해 개발된 **할 일(ToDo) 관리 API**입니다.  
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
![Swagger UI](https://github.com/taedyoverflow/clush_back/blob/master/img/swagger.png?raw=true)

---

## 4. 테스트케이스 작성 및 결과

### 테스트코드 설명
테스트 코드는 총 5개의 메서드로 구성되어 있으며, 각각의 테스트는 주요 API 기능을 검증합니다.  
**JUnit 5**와 **MockMvc**, **Mockito**를 사용하여 컨트롤러의 동작을 독립적으로 테스트하였습니다.

#### **테스트 목록**
1. **`createTask_shouldAddNewTask`**
   - `POST /api/tasks` 엔드포인트를 테스트.
   - 새로운 작업(Task)을 추가하고 반환값을 검증.

2. **`getTasks_shouldReturnAllTasks`**
   - `GET /api/tasks` 엔드포인트를 테스트.
   - 저장된 모든 작업(Task)의 목록을 반환하는 API 동작을 검증.

3. **`deleteTask_shouldRemoveTask`**
   - `DELETE /api/tasks/{id}` 엔드포인트를 테스트.
   - 특정 ID의 작업(Task)을 삭제하는 동작을 검증.

4. **`completeTask_shouldUpdateCompletedStatus`**
   - `PUT /api/tasks/{id}/complete` 엔드포인트를 테스트.
   - 특정 작업(Task)의 완료 상태를 업데이트하는 동작을 검증.

5. **`getCompletedTasks_shouldReturnOnlyCompletedTasks`**
   - `GET /api/tasks/completed` 엔드포인트를 테스트.
   - 완료된 작업(Task)만 필터링하여 반환하는 API 동작을 검증.

### 테스트 스크린샷
![Test](https://github.com/taedyoverflow/clush_back/blob/master/img/test.png?raw=true)

---


