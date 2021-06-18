package com.nikolayvaklinov.hibernate.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EagerLazyDemo {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            // 1. start transaction
            transaction.begin();

            // get the instructor detail object
            int theID = 1;
            Instructor instructor =
                    entityManager.find(Instructor.class, theID);
            // print the instructor detail
            System.out.println("Over 32 instructor: " + instructor);

            // print the associated instructor
            System.out.println("Over 32 the associated instructor: " +
                    instructor.getCourses());


            // 2. commit the transaction
            transaction.commit();
            System.out.println("Over 32: Done!");

        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }



    }
}



