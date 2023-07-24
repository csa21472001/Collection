package com.example.collectionp1.service;

import com.example.collectionp1.dto.Employee;
import com.example.collectionp1.exceptions.EmployeeAlreadyAddedException;
import com.example.collectionp1.exceptions.EmployeeNotFoundException;
import com.example.collectionp1.exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private List<Employee> employees;

    //            List.of(
//            new Employee("Иванов Иван Иванович", 5, 64665),
//    new Employee("Николаев Николай Николаевич", 3, 30000.0),
//    new Employee("Григорьев Григорий Григорьевич", 4, 39000.0),
//    new Employee("Давыдов Давид Давидович", 5, 50000.0),
//    new Employee("Ильин Илья Ильич", 4, 40000.0),
//    new Employee("Коновалова Алефтина Патриковна", 1, 50000.0),
//    new Employee("Заболотная Таисия Моисеевна", 5, 55000.0),
//    new Employee("Молодцов Вячеслав Иннокетьевич", 2, 55000.0),
//    new Employee("Федоров Федор Федорович", 2, 55000.0),
//    );
    private static final int EMPLOYESS_MAX_SIZE = 10;

    public EmployeeServiceImpl(List<Employee> employees) {
        this.employees = employees;
    }

    public void printItAll() {
        System.out.println("employees = " + employees);
    }

    @Override
    public Employee addEmployee(String fio) {
        if (employees.size() == EMPLOYESS_MAX_SIZE) {
            throw new EmployeeStorageIsFullException("Превышен лимит на новых сотрудников!!!");
        }
        Employee employee = new Employee(fio);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Сотрудник был добавлен ранее!");
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String fio) {
        Employee employee = new Employee(fio);
        if (!employees.remove(employee)) {
            throw new EmployeeNotFoundException("Cотрудник не найден!!!");
        }
        ;
        return employee;
    }

    @Override
    public Employee findEmployee(String fio) {
        Employee employee = new Employee(fio);
        if (employees.contains(employee)) {
            System.out.print("Сотрудник найден - " + employee.getFio());
        } else if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("Cотрудник не найден");
        }
        return employee;
    }

    @Override
    public List<Employee> printAll() {
        return employees;
    }

}

