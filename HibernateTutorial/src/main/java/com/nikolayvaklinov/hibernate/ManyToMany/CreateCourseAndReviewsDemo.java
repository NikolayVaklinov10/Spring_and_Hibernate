package com.nikolayvaklinov.hibernate.ManyToMany;

import com.nikolayvaklinov.hibernate.entity.Course;
import com.nikolayvaklinov.hibernate.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CreateCourseAndReviewsDemo {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            // 1. start transaction
            transaction.begin();

            // get the instructor from db
            int theID = 1;

            // create a course
            Course tempCourse =
                    new Course("Pacman - How To Score One Million Points");

            // save the course
            System.out.println("\nSaving the course ...");
            entityManager.persist(tempCourse);
            System.out.println("Saved the course: " + tempCourse);

            // create the students
            Student student1 = new Student("Joe", "Biden", "sleepy@joe.com");
            Student student2 = new Student("Vladimir", "Putin", "vlad@isWatchingU.com");
            // add students to the course
            tempCourse.addStudent(student1);
            tempCourse.addStudent(student2);

            // save the students
            System.out.println("\nSaving students ...");
            entityManager.persist(student1);
            entityManager.persist(student2);
            System.out.println("Saved students: " + tempCourse.getStudents());


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



