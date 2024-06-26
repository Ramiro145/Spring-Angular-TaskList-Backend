package com.ramirogonzalez.simpleTodoList.repository;

import com.ramirogonzalez.simpleTodoList.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long>{
    @Query(value = "SELECT * FROM task ORDER BY id ASC;" ,nativeQuery = true)
    List<Task> findAllByOrderByIdAsc();

}
