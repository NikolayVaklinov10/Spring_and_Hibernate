package com.nikolayvaklinov.hibernate.entity;

import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class FetchJoinDemo {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            // 1. start transaction
            transaction.begin();

            // Option 2: Hibernate query with HQL


            // get the instructor detail object
            int theID = 1;

            Query<Instructor> query =
                    (Query<Instructor>) entityManager.createQuery("SELECT i FROM Instructor i "
                                    + "JOIN FETCH i.courses "
                                    + "WHERE i.id=:theInstructorId",
                             Instructor.class);

            // set parameter on query
            query.setParameter("theInstructorId", theID);

            // print the instructor
            Instructor instructor = query.getSingleResult();

            System.out.println("Over 32 instructor: " + instructor);

            // print the associated instructor


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



