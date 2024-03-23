package com.crudDemo.crudDemo;

import com.crudDemo.crudDemo.doa.StudentDAO;
import com.crudDemo.crudDemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {


	public static void main(String[] args) {

		SpringApplication.run(CrudDemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
      return runner ->{

		  createStudent(studentDAO);

		  readStudent(studentDAO);
	  };
	}

	private void readStudent(StudentDAO studentDAO) {

		// create student object
		System.out.println("Creating new student object....");
		Student student = new Student("Rana","Osama","rana200@gmail.com");

		// save the student
		System.out.println("Saving the student.....");
		studentDAO.saveObject(student);

		// retrieve the student by ID
		System.out.println("Retrieving the student.....");
		Student tmpStudent = studentDAO.findById(student.getId());

		// display the student
		System.out.println("Found the student: "+ tmpStudent);


	}


	private void createStudent(StudentDAO studentDAO) {
		// create student object
		System.out.println("Creating new student object....");
		Student firstStudent = new Student("Haidy","Osama","haydy200@gmail.com");

		// save the student
		System.out.println("Saving the student.....");
		studentDAO.saveObject(firstStudent);

		// display the student info

		System.out.println("Saved student: " +firstStudent);
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
