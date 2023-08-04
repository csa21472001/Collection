package com.example.collectionp1.service;

import com.example.collectionp1.dto.Employee;

import java.util.Collection;


public interface EmployeeService {
    Employee addEmployee(int department, String fio, double salary);

    Employee removeEmployee(String fio);

    Employee findEmployee(String fio);

    Collection <Employee> printAll();

}
