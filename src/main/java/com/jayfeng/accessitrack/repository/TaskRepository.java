package com.jayfeng.accessitrack.repository;

import com.jayfeng.accessitrack.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}