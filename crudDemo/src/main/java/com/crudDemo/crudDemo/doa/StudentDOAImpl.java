package com.crudDemo.crudDemo.doa;

import com.crudDemo.crudDemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDOAImpl implements StudentDOA {

    // declare entity manager
    private EntityManager entityManager;

    // inject the entity manager


    @Autowired
    public StudentDOAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void saveObject(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // create a query
        TypedQuery<Student> query = entityManager.createQuery("From Student Order By lastName ", Student.class);


        // return the result
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        // create query
        TypedQuery<Student> query = entityManager.createQuery("From Student where lastName=:theData", Student.class);

        // set param  take the param name and value
        query.setParameter("theData", theLastName);

        // return the result
        return query.getResultList();
    }

    @Transactional
    @Override
    public void updateStudent(Student student) {

        // update student

        entityManager.merge(student);

    }

    @Transactional
    @Override
    public void delete(int id) {

        // retrieve the student with this id
        Student student = entityManager.find(Student.class, id);

        // delete this student
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteBasedOnLastName() {
        return entityManager.createQuery("DELETE FROM Student WHERE lastName='Osama'").executeUpdate();


    }

    @Override
    @Transactional
    public int deleteAll() {

        return entityManager.createQuery("DELETE FROM Student").executeUpdate();
    }
}
