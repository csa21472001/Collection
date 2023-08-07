package com.example.collectionp1.service;

import com.example.collectionp1.dto.Employee;
import com.example.collectionp1.exceptions.EmployeeAlreadyAddedException;
import com.example.collectionp1.exceptions.EmployeeNotFoundException;
import com.example.collectionp1.exceptions.EmployeeStorageIsFullException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employeeMap;
    private static final int EMPLOYESS_MAX_SIZE = 10;

    public EmployeeServiceImpl() {
        this.employeeMap = new HashMap<>();
    }

    @Override
    public Employee addEmployee(int department, String fio, double salary) {
        if (employeeMap.keySet().size() == EMPLOYESS_MAX_SIZE) {
            throw new EmployeeStorageIsFullException("Превышен лимит на новых сотрудников!!!");
        }
        Employee employee = new Employee(
                department,
                StringUtils.capitalize(fio),
                salary);
        if (employeeMap.containsKey(fio)) {
            throw new EmployeeAlreadyAddedException("Сотрудник был добавлен ранее!");
        }
        employeeMap.put(fio, employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String fio) {
        Employee employee = new Employee(fio);
        if (!employeeMap.containsKey(fio)) {
            throw new EmployeeNotFoundException("Cотрудник не найден!!!");
        } else {
            employeeMap.remove(fio);
        }
        return employee;
    }

    @Override
    public Employee findEmployee(String fio) {
        Employee employee = new Employee(fio);
        if (employeeMap.containsKey(fio)) {
            System.out.print("Сотрудник найден - " + employee);
        } else {
            throw new EmployeeNotFoundException("Cотрудник не найден");
        }
        return employee;
    }

    @Override
    public Collection<Employee> printAll() {
        return employeeMap.values();
    }



}

