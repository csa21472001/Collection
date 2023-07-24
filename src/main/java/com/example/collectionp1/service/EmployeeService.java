package com.example.collectionp1.service;

import com.example.collectionp1.dto.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(String fio);

    Employee removeEmployee(String fio);

    Employee findEmployee(String fio);

    List<Employee> printAll();
}
