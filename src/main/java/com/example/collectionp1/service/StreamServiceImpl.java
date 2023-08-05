package com.example.collectionp1.exceptions;

import com.example.collectionp1.dto.Employee;

import com.example.collectionp1.service.EmployeeService;

import com.example.collectionp1.service.StreamService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;

import java.util.stream.Collectors;

@Service
public class StreamServiceImpl implements StreamService {
    public final EmployeeService employeeService;

    public StreamServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee MaxSalaryByDepartment(int department) {
        return employeeService.printAll().stream()
                .filter(empl -> empl.getDepartment() == department)
                .max(Comparator.comparingDouble(empl2 -> empl2.getSalary()))
                .orElseThrow(() -> new EmployeeNotFoundException("Нет сотрудника в отделе" + department));
    }
    @Override
    public Employee MinSalaryByDepartment(int department) {
        return employeeService.printAll().stream()
                .filter(empl -> empl.getDepartment() == department)
                .min(Comparator.comparingDouble(empl2 -> empl2.getSalary()))
                .orElseThrow( () -> new EmployeeNotFoundException("Нет сотрудника в отделе" + department ));
    }
    @Override
    public Collection<Employee> getThemAllByDepartment(int department){
        return employeeService.printAll().stream()
                .filter(empl -> empl.getDepartment() == department)
                .collect(Collectors.toList());
    }
    @Override
    public Map<Integer, Collection<Employee>> getThemAll() {
        return employeeService.printAll().stream()
                .collect(Collectors.groupingBy(empl -> empl.getDepartment()));
    }

}
