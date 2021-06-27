package com.nikolayvaklinov.springboot.dao;

import com.nikolayvaklinov.springboot.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    // define field for entity manager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }


    @Override
    public List<Employee> findAll() {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);
        // create a query
        Query<Employee> theQuery =
                currentSession.createQuery("from Employee ", Employee.class);
        // execute query and get result list
        List<Employee> employees = theQuery.getResultList();
        // return the results
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Employee theEmployee = currentSession.get(Employee.class, theId);

        return theEmployee;
    }

    @Override
    public void save(Employee theEmployee) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(theEmployee);

    }

    @Override
    public void deleteBId(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery =
                currentSession.createQuery(
                        "delete from Employee where id=:employeeId");
        theQuery.setParameter("employeeId", theId);

        theQuery.executeUpdate();

    }
}
