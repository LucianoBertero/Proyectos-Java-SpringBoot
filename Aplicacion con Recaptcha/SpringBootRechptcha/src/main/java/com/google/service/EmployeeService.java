package com.google.service;

import com.google.entities.EmployeeEntity;

import java.util.List;

public interface EmployeeService {

    List<EmployeeEntity> findAll();

    EmployeeEntity findById(Long id);

    void createEmployee(EmployeeEntity employeEntity);

    void deleteEmployee(Long id);





}
