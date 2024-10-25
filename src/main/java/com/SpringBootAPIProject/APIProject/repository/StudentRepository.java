package com.SpringBootAPIProject.APIProject.repository;

import com.SpringBootAPIProject.APIProject.model.Student;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {


}
