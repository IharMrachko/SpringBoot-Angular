package com.students.demo.repo;

import com.students.demo.models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {

    Student findStudentById(Long id);

    @Override
    void delete(Student deleted);
}