package com.nikolayvaklinov.aopdemo;

import com.nikolayvaklinov.aopdemo.dao.AccountDAO;
import com.nikolayvaklinov.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {

        // read spring java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);
        // get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        // GET MEMBERSHIP BEAN FROM SPRING CONTAINER
        MembershipDAO theMembershipDAO = context.getBean("membershipDAO",MembershipDAO.class);

        theMembershipDAO.addAccount();

        // call the business method
        theAccountDAO.addAccount();

        theMembershipDAO.addSilly();


        // close the context
        context.close();


    }
}
