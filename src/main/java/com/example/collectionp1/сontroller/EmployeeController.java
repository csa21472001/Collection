package com.example.collectionp1.сontroller;

import com.example.collectionp1.dto.Employee;
import com.example.collectionp1.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    public final EmployeeService employeeService;
//    private final Map<String, Employee> employeeMap;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam String fio) {
        return employeeService.addEmployee(fio);

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
