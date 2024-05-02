package com.crudDemo.crudDemo;

import com.crudDemo.crudDemo.doa.StudentDAO;
import com.crudDemo.crudDemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {


    public static void main(String[] args) {

        SpringApplication.run(CrudDemoApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {

            createStudent(studentDAO);

            readStudent(studentDAO);

            createMultipleStudents(studentDAO);

            queryForStudents(studentDAO);

            queryStudentByLastName(studentDAO);

            updateStudent(studentDAO);

            deleteStudent(studentDAO);

            deleteBasedOnCondition(studentDAO);

            deleteAllStudents(studentDAO);

        };
    }

    private void deleteAllStudents(StudentDAO studentDAO) {

        System.out.println("Deleting all student.... ");

        int numOfStudentDeleted = studentDAO.deleteAll();

        System.out.println("The number of student that deleted is " + numOfStudentDeleted);
    }

    private void deleteBasedOnCondition(StudentDAO studentDAO) {

        System.out.println("Deleting student that have last name OSAMA");

        int numOfStudentDeleted = studentDAO.deleteBasedOnLastName();

        System.out.println("The number of student that deleted is " + numOfStudentDeleted);
    }

    private void deleteStudent(StudentDAO studentDAO) {

        // delete student
        int id = 3;

        System.out.println("Deleting student with id: " + id);

        studentDAO.delete(id);
    }

    private void updateStudent(StudentDAO studentDAO) {

        // retrieve student based on id
        int studentId = 1;
        System.out.println("Getting a student with id: " + studentId);

        // find the student by id
        Student tmpStudent = studentDAO.findById(studentId);

        // Update the student first name
        System.out.println("Updating student...");

        // set the first name
        tmpStudent.setFirstName("Rana");
        studentDAO.updateStudent(tmpStudent);

        // Display the updated student
        System.out.println("The updated student: " + tmpStudent);
    }

    private void queryStudentByLastName(StudentDAO studentDAO) {

        // get list of student
        List<Student> students = studentDAO.findByLastName("Duck");

        // display the students

        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void queryForStudents(StudentDAO studentDAO) {

        // get a list of student
        List<Student> students = studentDAO.findAll();

        // display the student
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void readStudent(StudentDAO studentDAO) {

        // create student object
        System.out.println("Creating new student object....");
        Student student = new Student("Rana", "Osama", "rana200@gmail.com");

        // save the student
        System.out.println("Saving the student.....");
        studentDAO.saveObject(student);

        // retrieve the student by ID
        System.out.println("Retrieving the student.....");
        Student tmpStudent = studentDAO.findById(student.getId());

        // display the student
        System.out.println("Found the student: " + tmpStudent);


    }


    private void createStudent(StudentDAO studentDAO) {
        // create student object
        System.out.println("Creating new student object....");
        Student firstStudent = new Student("Haidy", "Osama", "haydy200@gmail.com");

        // save the student
        System.out.println("Saving the student.....");
        studentDAO.saveObject(firstStudent);

        // display the student info

        System.out.println("Saved student: " + firstStudent);
    }

    private void createMultipleStudents(StudentDAO studentDAO) {

        // create multiple students
        System.out.println("Creating 3 student objects ...");
        Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
        Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");
        Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@luv2code.com");

        // save the student objects
        System.out.println("Saving the students ...");
        studentDAO.saveObject(tempStudent1);
        studentDAO.saveObject(tempStudent2);
        studentDAO.saveObject(tempStudent3);
    }

}
