package ru.arutyunovg4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.arutyunovg4.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository <Task, Long> {
}
