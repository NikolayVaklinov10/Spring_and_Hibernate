package com.nikolayvaklinov.hibernate.entity;

import javax.persistence.*;
import java.util.List;

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



            TypedQuery<Student> query =
                    entityManager.createQuery("SELECT c FROM Student c where c.lastName = 'Vaklinov' ", Student.class);
            List<Student> results = query.getResultList();
            tempStudent1.getFirstName("Nick");

            System.out.println("The student record is" + results);

            Student myStudent = entityManager.find(Student.class,5);
            myStudent.setFirstName("Paolo");
            entityManager.remove(myStudent);


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
