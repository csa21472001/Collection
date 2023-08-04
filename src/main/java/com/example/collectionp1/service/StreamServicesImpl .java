package com.example.collectionp1.service;

import com.example.collectionp1.dto.Employee;

import java.util.Collection;
import java.util.Optional;

public class StreamServicesImpl implements EmployeeService {
    public final EmployeeService employeeService;

    public StreamServices(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee returnMaxSalaryByDepartment(int department) {
        Optional<String> maxSalary = employeeMap.stream()
                .forEach()
    }
    public Employee returnMinSalaryByDepartment(int department){

    }
    Collection<Employee> getThemAll(int department){

    }
    Map<Integer, Collection<Employee>> getThemAllByDepartment{

    }

    }

