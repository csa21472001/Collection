package com.example.collectionp1.service;
import com.example.collectionp1.dto.Employee;
import com.example.collectionp1.exceptions.EmployeeAlreadyAddedException;
import com.example.collectionp1.exceptions.EmployeeNotFoundException;
import com.example.collectionp1.exceptions.EmployeeStorageIsFullException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



class EmployeeServiceImplTest {
    EmployeeServiceImpl underTest = new EmployeeServiceImpl();
    Employee employee = new Employee(1, "Ivan Ivanov", 50000);
    @AfterEach
    void cleanup() {
        underTest.removeEmployee(employee.getFio());
    }
    @Test
    void addEmployee_freshmoreEmployee_employeeAdded() {
        Employee result = underTest.addEmployee(employee.getDepartment(), employee.getFio(), employee.getSalary());
        assertEquals(employee, result);
        assertTrue(underTest.printAll().contains(employee));
    }

    @Test
    void addEmployee_employeeHasBeenAdded_thrownException() {
        Employee result = underTest.addEmployee(employee.getDepartment(), employee.getFio(), employee.getSalary());
        EmployeeAlreadyAddedException ex = assertThrows(EmployeeAlreadyAddedException.class,
                () -> underTest.addEmployee(employee.getDepartment(), employee.getFio(), employee.getSalary()));
        assertEquals("Сотрудник был добавлен ранее!", ex.getMessage());
    }

    @Test
    void addEmployee_EMPLOYESS_MAX_SIZE_exceeded_thrownException() {
        int empMax = 4;
        for (int i = 0; i < empMax; i++) {
            underTest.addEmployee(1, "Ivan Ivanov" + String.valueOf(i), 5929.0);
        }
        EmployeeStorageIsFullException ex = assertThrows(EmployeeStorageIsFullException.class,
                () -> underTest.addEmployee(employee.getDepartment(), employee.getFio(), employee.getSalary()));
        assertEquals("Превышен лимит на новых сотрудников!!!", ex.getMessage());
    }

    @Test
    void removeEmployee_employeeIsNotInMap_thrownException() {
        EmployeeNotFoundException ex =
                assertThrows(EmployeeNotFoundException.class,
                        () -> underTest.removeEmployee("Ivan Ivanov"));
        assertEquals("Cотрудник не найден!!!", ex.getMessage());
    }

    @Test
    void removeEmployee_employeeIsInMap_employeeRemovedAndReturned() {
        underTest.addEmployee(employee.getDepartment(), employee.getFio(), employee.getSalary());
        Employee result = underTest.removeEmployee(employee.getFio());
        assertEquals(employee, result);
        assertFalse(underTest.printAll().contains(employee));
    }

    @Test
    void findEmployee_employeeMissing_thrownEmployeeNotFoundException() {
        assertThrows(EmployeeNotFoundException.class,
                () -> underTest.findEmployee(employee.getFio()));
    }

    @Test
    void findEmployee_employeeFound_employeeFoundAndReturned() {
        underTest.addEmployee(employee.getDepartment(), employee.getFio(), employee.getSalary());
        Employee result = underTest.findEmployee(employee.getFio());
        assertEquals(employee, result);
        assertTrue(underTest.printAll().contains(employee));
    }

    @Test
    void printAll_emptyList_returnEmptyCollection() {
        Collection<Employee> result = underTest.printAll();
        assertIterableEquals(Collections.emptyList(), result);

    }

    @Test
    void printAll_thereAreEmployees_returnEmployList() {
        underTest.addEmployee(employee.getDepartment(), employee.getFio(), employee.getSalary());
        Collection<Employee> result = underTest.printAll();
        assertIterableEquals(List.of(employee), result);
    }

}