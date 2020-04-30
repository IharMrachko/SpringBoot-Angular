package com.students.demo.controllers;

import com.students.demo.models.Student;
import com.students.demo.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentControllers {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/students")
    public Iterable<Student> students() {
        return studentRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/students")
    @CrossOrigin(value = "http://localhost:4200")
    public Student save(@RequestBody Student student) {
        studentRepository.save(student);
        return student;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/students/{id}")
    public Student show(@PathVariable Long id) {
        return studentRepository.findStudentById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/students/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student contact) {
        Student c = studentRepository.findStudentById(id);
        if (contact.getName() != null)
            c.setName(contact.getName());
        if (contact.getAddress() != null)
            c.setAddress(contact.getAddress());
        if (contact.getCity() != null)
            c.setCity(contact.getCity());
        if (contact.getPhone() != null)
            c.setPhone(contact.getPhone());
        if (contact.getEmail() != null)
            c.setEmail(contact.getEmail());
        studentRepository.save(c);
        return contact;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/students/{id}")
    public void delete(@PathVariable Long id) {
        Student contact = studentRepository.findStudentById(id);
        studentRepository.delete(contact);
    }
}
