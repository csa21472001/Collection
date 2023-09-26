package com.example.collectionp1.сontroller;

import com.example.collectionp1.dto.Employee;
import com.example.collectionp1.service.EmployeeService;
import com.example.collectionp1.util.EmployeeNameValidator;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    public final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

//        /departments/max-salary?departmentId=5

    @GetMapping("/add")
    public Employee add(@RequestParam int department, @RequestParam String fio, @RequestParam double salary) {
        EmployeeNameValidator.checkName(fio);
        return employeeService.addEmployee(department, fio, salary);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam String fio) {
        return employeeService.removeEmployee(fio);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String fio) {
        return employeeService.findEmployee(fio);
    }

    @GetMapping
    public Collection<Employee> printAll() {
        return employeeService.printAll();
    }

    @ExceptionHandler(Exception.class)
    public String handlException(Exception ex) {
        return "Получена ошибка: " + ex.getMessage();
    }


}
