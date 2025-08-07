package com.cecheverry.dtstaskbackendjava.repository;

import com.cecheverry.dtstaskbackendjava.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
