package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TaskController.class)
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createTask_shouldAddNewTask() throws Exception {
        Task newTask = new Task();
        newTask.setName("New Task");
        newTask.setPriority("Low");
        newTask.setCompleted(false);

        when(repository.save(any(Task.class))).thenReturn(newTask);

        mockMvc.perform(post("/api/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newTask)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("New Task"))
                .andExpect(jsonPath("$.priority").value("Low"))
                .andExpect(jsonPath("$.completed").value(false));
    }

    @Test
    void getTasks_shouldReturnAllTasks() throws Exception {
        Task task1 = new Task();
        task1.setId(1L);
        task1.setName("Task 1");
        task1.setPriority("High");

        Task task2 = new Task();
        task2.setId(2L);
        task2.setName("Task 2");
        task2.setPriority("Medium");

        when(repository.findAll()).thenReturn(Arrays.asList(task1, task2));

        mockMvc.perform(get("/api/tasks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Task 1"))
                .andExpect(jsonPath("$[1].priority").value("Medium"));
    }

    @Test
    void deleteTask_shouldRemoveTask() throws Exception {
        Long taskId = 1L;

        doNothing().when(repository).deleteById(taskId);

        mockMvc.perform(delete("/api/tasks/" + taskId))
                .andExpect(status().isOk());

        verify(repository, times(1)).deleteById(taskId);
    }

    @Test
    void completeTask_shouldUpdateCompletedStatus() throws Exception {
        Task existingTask = new Task();
        existingTask.setId(1L);
        existingTask.setName("Task 1");
        existingTask.setPriority("High");
        existingTask.setCompleted(false);

        Task updatedTask = new Task();
        updatedTask.setId(1L);
        updatedTask.setName("Task 1");
        updatedTask.setPriority("High");
        updatedTask.setCompleted(true);

        when(repository.findById(1L)).thenReturn(Optional.of(existingTask));
        when(repository.save(any(Task.class))).thenReturn(updatedTask);

        mockMvc.perform(put("/api/tasks/1/complete")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("true")) // 요청 본문으로 완료 상태(true) 전송
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.completed").value(true));
    }

    @Test
    void getCompletedTasks_shouldReturnOnlyCompletedTasks() throws Exception {
        Task completedTask1 = new Task();
        completedTask1.setId(1L);
        completedTask1.setName("Completed Task 1");
        completedTask1.setPriority("High");
        completedTask1.setCompleted(true);

        Task completedTask2 = new Task();
        completedTask2.setId(2L);
        completedTask2.setName("Completed Task 2");
        completedTask2.setPriority("Medium");
        completedTask2.setCompleted(true);

        when(repository.findByCompleted(true)).thenReturn(Arrays.asList(completedTask1, completedTask2));

        mockMvc.perform(get("/api/tasks/completed"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Completed Task 1"))
                .andExpect(jsonPath("$[1].priority").value("Medium"));
    }
}
