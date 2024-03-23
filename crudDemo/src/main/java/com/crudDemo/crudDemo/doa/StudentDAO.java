package com.crudDemo.crudDemo.doa;

import com.crudDemo.crudDemo.entity.Student;

public interface StudentDAO {

    void saveObject(Student student);
    Student findById(int id);

}
