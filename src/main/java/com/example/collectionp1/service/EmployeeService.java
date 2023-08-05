package com.example.collectionp1.service;

import com.example.collectionp1.dto.Employee;
import com.example.collectionp1.exceptions.EmployeeNotFoundException;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;


public interface EmployeeService {
    Employee addEmployee(int department, String fio, double salary);

    Employee removeEmployee(String fio);

    Employee findEmployee(String fio);

    Collection <Employee> printAll();

}
