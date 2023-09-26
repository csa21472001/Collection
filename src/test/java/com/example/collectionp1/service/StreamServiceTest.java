package com.example.collectionp1.service;

import com.example.collectionp1.dto.Employee;
import com.example.collectionp1.exceptions.EmployeeNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class StreamServiceTest {
    @Mock
    EmployeeService employeeService;
    @InjectMocks
    StreamServiceImpl underTest;

    Employee ivan = new Employee(1, "Ivan Ivanov", 20000);
    Employee fedor = new Employee(2, "Fedor Fedorov", 30000);
    Employee jorik = new Employee(1, "Jorik", 10000000);
    Collection<Employee> employees;
    int department = 1;

    @BeforeEach
    void beforeEach() {
        employees = List.of(ivan, fedor, jorik);
    }

    @Test
    void findMaxSalaryEmployee_employeeInDepartment_returnEmployeeWithMaxSalary() {
        when(employeeService.printAll()).thenReturn(employees);
        Employee result = underTest.MaxSalaryByDepartment(1);
        assertEquals(jorik, result);
    }

    @Test
    void findMaxSalaryEmployee_employeeNotFound_returnThrowException() {
        when(employeeService.printAll()).thenReturn(Collections.emptyList());

        EmployeeNotFoundException ex = assertThrows(EmployeeNotFoundException.class,
                () -> underTest.MaxSalaryByDepartment(department));
        assertEquals("Указанного сотрудника нет в отделе" + department, ex.getMessage());

    }

    @Test
    void findMinSalaryEmployee_employeeInDepartment_returnEmployeeWithMinSalary() {
        when(employeeService.printAll()).thenReturn(employees);
        Employee result = underTest.MinSalaryByDepartment(department);
        assertEquals(ivan, result);
    }

    @Test
    void findMinSalaryEmployee_employeeNotFound_returnThrowException() {
        when(employeeService.printAll()).thenReturn(Collections.emptyList());

        EmployeeNotFoundException ex = assertThrows(EmployeeNotFoundException.class,
                () -> underTest.MaxSalaryByDepartment(department));
        assertEquals("Указанного сотрудника нет в отделе" + department, ex.getMessage());
    }

    @Test
    void getThemAllByDepartment_emptyDepartment_returnEmptyCollection() {
        when(employeeService.printAll()).thenReturn(Collections.emptyList());
        Collection<Employee> result = underTest.getThemAllByDepartment(3);
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    void getThemAllByDepartment() {
        when(employeeService.printAll()).thenReturn(employees);
        Collection<Employee> result = underTest.getThemAllByDepartment(1);
        assertEquals(employees, result);
    }

    @Test
    void getThemAll_allEmployees_returnMap() {
        when(employeeService.printAll()).thenReturn(employees);
        Map<Integer, List<Employee>> result = underTest.getThemAll();
        assertEquals(Map.of(1, List.of(ivan, jorik), 2, List.of(fedor)), result);
    }

    @Test
    void getThemAll_noEmployees_returnEmptyMap() {
        when(employeeService.printAll()).thenReturn(Collections.emptyList());
        Map<Integer, List<Employee>> result = underTest.getThemAll();
        assertEquals(Collections.EMPTY_MAP, result);
    }
}