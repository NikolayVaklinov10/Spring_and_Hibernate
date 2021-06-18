package com.nikolayvaklinov.hibernate.ManyToMany;

import com.nikolayvaklinov.hibernate.entity.Course;
import com.nikolayvaklinov.hibernate.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AddCoursesForJoeDemo {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            // 1. start transaction
            transaction.begin();

            // get the instructor from db
            int theID = 1;

            // get the student joe from database
            Student tempStudent = entityManager.find(Student.class, theID);

            System.out.println("\nLoaded student: " + tempStudent);
            System.out.println("Course: " + tempStudent.getCourses());
            // create more courses
            Course newCourse2 = new Course("Spell checking");
            Course newCourse3 = new Course("Tennis Lessons");
            // add student to courses
            newCourse2.addStudent(tempStudent);
            newCourse3.addStudent(tempStudent);

            // save the courses
            System.out.println("\nSaving the courses ...");
            entityManager.persist(newCourse2);
            entityManager.persist(newCourse3);





            // 2. commit the transaction
            transaction.commit();
            System.out.println("Done!");

        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }



    }
}



