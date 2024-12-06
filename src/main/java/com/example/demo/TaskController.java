package com.example.demo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@Tag(name = "Clush 할 일 관리", description = "할 일(Task)을 관리하기 위한 API by taedy")
public class TaskController {

    @Autowired
    private TaskRepository repository;

    @GetMapping
    @Operation(summary = "모든 할 일 조회", description = "저장된 모든 할 일(Task)의 목록을 조회합니다.")
    public List<Task> getTasks() {
        return repository.findAll();
    }

    @PostMapping
    @Operation(summary = "할 일 생성", description = "새로운 할 일(Task)을 생성합니다.")
    public Task createTask(@RequestBody Task task) {
        return repository.save(task);
    }

    @PutMapping("/{id}")
    @Operation(summary = "할 일 수정", description = "ID로 지정된 기존 할 일(Task)을 수정합니다.")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        task.setId(id);
        return repository.save(task);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "할 일 삭제", description = "ID로 지정된 할 일(Task)을 삭제합니다.")
    public void deleteTask(@PathVariable Long id) {
        repository.deleteById(id);
    }

    // 완료 상태 업데이트 API
    @PutMapping("/{id}/complete")
    @Operation(summary = "할 일 완료 상태 업데이트", description = "ID로 지정된 할 일(Task)의 완료 상태를 업데이트합니다.(추가 기능)")
    public Task completeTask(@PathVariable Long id, @RequestBody boolean completed) {
        Task task = repository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        task.setCompleted(completed);
        return repository.save(task);
    }

    // 완료된 작업 필터링 API
    @GetMapping("/completed")
    @Operation(summary = "완료된 할 일 조회", description = "완료된 할 일(Task)만 조회합니다.(추가 기능)")
    public List<Task> getCompletedTasks() {
        return repository.findByCompleted(true);
    }
}
