package com.nikolayvaklinov.hibernate.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GetBiDiCoursesDemo {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            // 1. start transaction
            transaction.begin();

            // get the instructor from db
            int theID = 1;
            Instructor instructor =
                    entityManager.find(Instructor.class, theID);

            System.out.println("Instructor: " + instructor.getFirstName()+ " " + instructor.getLastName());
            // get courses for the instructor
            System.out.println("Courses: " + instructor.getCourses());




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



