package com.nikolayvaklinov.hibernate.Unidirectional;

import com.nikolayvaklinov.hibernate.entity.Course;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeleteCourseAndReviewsDemo {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            // 1. start transaction
            transaction.begin();
            int theID = 10;

            // get the course
            Course tempCourse = entityManager.find(Course.class, theID);
            // print the course
            System.out.println(tempCourse);
            // print the course reviews
            System.out.println(tempCourse.getReviews());

            System.out.println("Deleting the course...");
            entityManager.remove(tempCourse);

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



