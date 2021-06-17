package com.nikolayvaklinov.hibernate.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CreateBiDiInstructorDemo {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {

            // create the objects
            Instructor instructor =
                    new Instructor("Jennifer", "Lowrance", "jennie@gmail.com");

            InstructorDetail instructorDetail =
                    new InstructorDetail(
                            "Mind blowing Movies",
                            "Acting"
                    );

            // associate the objects
            instructor.setInstructorDetail(instructorDetail);

            // 1. start transaction
            transaction.begin();

            // save the instructor
            System.out.println("Saving instructor:" + instructor);
            entityManager.persist(instructor);

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



