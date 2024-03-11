package com.exercise.studentregistrationvalidation.repo;

import com.exercise.studentregistrationvalidation.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {
}
