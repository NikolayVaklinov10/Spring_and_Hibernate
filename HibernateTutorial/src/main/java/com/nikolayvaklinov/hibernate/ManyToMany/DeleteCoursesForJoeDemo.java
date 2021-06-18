package com.nikolayvaklinov.hibernate.ManyToMany;

import com.nikolayvaklinov.hibernate.entity.Course;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeleteCoursesForJoeDemo {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            // 1. start transaction
            transaction.begin();

            // get the instructor from db
            int theID = 10;

            // get the student joe from database
            Course tempCourse = entityManager.find(Course.class, theID);

            System.out.println("deleting a course: " + tempCourse);
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



