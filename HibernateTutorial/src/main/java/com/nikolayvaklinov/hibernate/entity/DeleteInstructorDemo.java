package com.nikolayvaklinov.hibernate.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeleteInstructorDemo {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            // 1. start transaction
            transaction.begin();

            // get instructor by primary key
            Instructor instructor = entityManager.find(Instructor.class, 3);
            // delete the instructor
            entityManager.remove(instructor);

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



