package com.example.collectionp1.service;

import com.example.collectionp1.dto.Employee;

import java.util.Collection;
import java.util.Map;

public interface StreamService {
    Employee MaxSalaryByDepartment(int department);

    Employee MinSalaryByDepartment(int department);

    Collection<Employee> getThemAllByDepartment(int department);
    Map<Integer, Collection<Employee>> getThemAll();
}
