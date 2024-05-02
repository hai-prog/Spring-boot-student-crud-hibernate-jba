package com.crudDemo.crudDemo.doa;

import com.crudDemo.crudDemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void saveObject(Student student);

    Student findById(int id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void updateStudent(Student student);

    void delete(int id);

    int deleteBasedOnLastName();

    int deleteAll();


}
