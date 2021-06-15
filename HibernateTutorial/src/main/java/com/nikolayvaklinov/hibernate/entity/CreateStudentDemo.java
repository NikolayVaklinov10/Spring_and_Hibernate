package com.nikolayvaklinov.hibernate.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CreateStudentDemo {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            // 2. start transaction
            transaction.begin();

            // 1. create the student
            Student tempStudent =
                    new Student("Paul", "Wall", "paul@gmail.com");

            // save the student
            entityManager.persist(tempStudent);

            // commit the transaction
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



