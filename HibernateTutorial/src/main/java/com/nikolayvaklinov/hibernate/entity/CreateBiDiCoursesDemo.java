package com.nikolayvaklinov.hibernate.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CreateBiDiCoursesDemo {

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

            // create some courses
            Course tempCourse1 = new Course("Acoustic Guitar - The Path to Fame");
            Course tempCourse2 = new Course("The Pinball Masterclass");
            Course tempCourse3 = new Course("Latin Dance Tango");
            Course tempCourse4 = new Course("Acting Class like Al Pacino");
            Course tempCourse5 = new Course("Accounting course");


            // add courses to instructor
            instructor.add(tempCourse1);
            instructor.add(tempCourse2);
            instructor.add(tempCourse3);
            instructor.add(tempCourse4);
            instructor.add(tempCourse5);

            // save the courses
            entityManager.persist(tempCourse1);
            entityManager.persist(tempCourse2);
            entityManager.persist(tempCourse3);
            entityManager.persist(tempCourse4);
            entityManager.persist(tempCourse5);



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



