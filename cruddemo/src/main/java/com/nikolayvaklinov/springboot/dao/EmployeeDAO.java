package com.nikolayvaklinov.springboot.dao;

import com.nikolayvaklinov.springboot.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAll();

    public Employee findById(int theId);

    public void save(Employee theEmployee);

    public void deleteBId(int theId);
}

