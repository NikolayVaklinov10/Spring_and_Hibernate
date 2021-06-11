package com.nikolayvaklinov.SpringAnotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

    public static void main(String[] args) {

        // read spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContextAnnotations.xml");
        // get the bean from spring container
        Coach theCoach = context.getBean("tennisCoach",Coach.class);
        // call a method on the bean
        System.out.println(theCoach.getDailyWorkout());
        // close the context
        context.close();
    }
}
