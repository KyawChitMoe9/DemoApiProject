package com.SpringBootAPIProject.APIProject.studentController;

import com.SpringBootAPIProject.APIProject.model.Student;
import com.SpringBootAPIProject.APIProject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    StudentRepository repo;
    //get all teh students/
    // localhost:8080/api
    @GetMapping("/all")
    public List<Student> getAllStudents(){
        List<Student> students = repo.findAll();
        return students;
    }

    //localhost:8080/student/1
    @GetMapping("/get/{id}")
    public Student getStudent(@PathVariable int id){
        Student student = repo.findById(id).get();
        return student;
    }

    //localhost:8080/student/add
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void  createStudent( @RequestBody Student student){
       repo.save(student);
    }

    @PutMapping("/update/{id}")
    public Student updateStudent (@PathVariable int id ){
        Student student = repo.findById(id).get();
        student.setName("မောင်ကျော်ကြီးက ချစ်တတ်တယ်နော်");
        student.setPercentage(100);
        repo.save(student);
        return student;

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        Optional<Student> student = repo.findById(id);

        if (student.isPresent()) {
            repo.delete(student.get());
            return ResponseEntity.ok("Student with Id " + id + " has been deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Student with ID " + id + " not found.");
            }

        }


    }


