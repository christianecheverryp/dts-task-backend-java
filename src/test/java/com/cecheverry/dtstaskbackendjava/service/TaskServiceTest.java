package com.cecheverry.dtstaskbackendjava.service;

import com.cecheverry.dtstaskbackendjava.model.Task;
import com.cecheverry.dtstaskbackendjava.model.TaskStatus;
import com.cecheverry.dtstaskbackendjava.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;


public class TaskServiceTest {
    private TaskRepository taskRepository;
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        taskRepository = Mockito.mock(TaskRepository.class);
        taskService = new TaskService(taskRepository);
    }

    @Test
    void testCreateTask() {
        Task task = new Task();
        task.setTitle("Demo");
        task.setStatus(TaskStatus.PENDING);
        task.setDueDateTime(LocalDateTime.now());

        Mockito.when(taskRepository.save(any(Task.class))).thenReturn(task);

        Task created = taskService.createTask(task);

        assertNotNull(created);
        assertEquals("Demo", created.getTitle());
    }

    @Test
    void testGetTaskById() {
        Task task = new Task();
        task.setId(1L);

        Mockito.when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

        Optional<Task> result = taskService.getTaskById(1L);

        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId());
    }

    @Test
    void testDeleteTask() {
        Long id = 1L;

        assertDoesNotThrow(() -> taskService.deleteTask(id));
        Mockito.verify(taskRepository).deleteById(id);
    }

    @Test
    void testUpdateTaskStatus() {
        Task task = new Task();
        task.setId(1L);
        task.setTitle("Demo");
        task.setStatus(TaskStatus.PENDING);
        task.setDueDateTime(LocalDateTime.now());

        Mockito.when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

        Mockito.when(taskRepository.save(any(Task.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Task result = taskService.updateTaskStatus(1L, TaskStatus.DONE);

        assertNotNull(result);
        assertEquals(TaskStatus.DONE, result.getStatus());
        Mockito.verify(taskRepository).findById(1L);
        Mockito.verify(taskRepository).save(task);
    }
}
