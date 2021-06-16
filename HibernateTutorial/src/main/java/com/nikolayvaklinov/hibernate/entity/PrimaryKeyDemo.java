package com.nikolayvaklinov.hibernate.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PrimaryKeyDemo {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            // 2. start transaction
            transaction.begin();

            // 1. create 3 student objects
            Student tempStudent1 =
                    new Student("Nikolay", "Vaklinov", "nick@yahoo.com");
            Student tempStudent2 =
                    new Student("Diletta", "Leotta", "dille@apple.com");
            Student tempStudent3 =
                    new Student("Kim", "JonUn", "kim@abv.bg");
           Student tempStudent4;



            // save the student
            entityManager.persist(tempStudent1);
            entityManager.persist(tempStudent2);
            entityManager.persist(tempStudent3);

            // commit the transaction
            transaction.commit();

            System.out.println("Saved student, generate id: "+tempStudent1.getId());
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }




    }
}
