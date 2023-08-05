package com.example.collectionp1.сontroller;

import com.example.collectionp1.dto.Employee;
import com.example.collectionp1.exceptions.StreamServiceImpl;
import com.example.collectionp1.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/departments")
public class StreamController {
    public final StreamServiceImpl streamService;
    public StreamController(StreamServiceImpl streamService) {
        this.streamService = streamService;
    }
    @GetMapping("/max-Salary")
    public Employee MaxSalaryByDepartment(int department) {
        return streamService.MaxSalaryByDepartment(department);
    }
    @GetMapping("/min-Salary")
    public Employee MinSalaryByDepartment(int department) {
        return streamService.MinSalaryByDepartment(department);
    }
    @GetMapping("/all")
    public Collection <Employee> getThemAllByDepartment(int department) {
        return streamService.getThemAllByDepartment(department);
    }
    @GetMapping("/all")
    public Map <Integer, Collection<Employee>> getThemAll() {
        return streamService.getThemAll();
    }
}