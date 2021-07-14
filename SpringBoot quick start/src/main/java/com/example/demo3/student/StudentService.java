package com.example.demo3.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){

        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if(studentByEmail.isPresent()){
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
//        System.out.println(student.toString());
    }

    public void deleteStudent(Long id) {
        boolean exist = studentRepository.existsById(id);
        if(!exist){
            throw new IllegalStateException("student id " + id + " does not exist");
        }

        studentRepository.deleteById(id);

    }
    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId).orElseThrow(()->{
            throw new IllegalStateException("student with " + studentId + " does not exist");
        });

        if(name!=null&&
                name.length()>0&&
                !Objects.equals(student.getName(), name)){
            student.setName(name);
            System.out.println(name);
        }
        else {System.out.println("name is not updated "+name);
        System.out.println(name!=null);
        System.out.println(name.length()>0);
        System.out.println( Objects.equals(student.getName(), name));}

        if(email!=null&&
                email.length()>0&&
                !Objects.equals(student.getEmail(), email)){
            Optional<Student> studentByEmail = studentRepository.findStudentByEmail(email);
            if(studentByEmail.isPresent()){
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
            System.out.println(email);
        }else System.out.println("email is not updated "+email);

    }
}
