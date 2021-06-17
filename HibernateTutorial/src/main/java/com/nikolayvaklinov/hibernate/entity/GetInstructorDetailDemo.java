package com.nikolayvaklinov.hibernate.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GetInstructorDetailDemo {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            // 1. start transaction
            transaction.begin();

            // get the instructor detail object
            int theID = 2;
            InstructorDetail instructorDetail =
                    entityManager.find(InstructorDetail.class, theID);
            // print the instructor detail
            System.out.println("instructorDetail: " + instructorDetail);
            // print the associated instructor
            System.out.println("the associated instructor: " +
                    instructorDetail.getInstructor());


            // 2. commit the transaction
            transaction.commit();

        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }



    }
}



