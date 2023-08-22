package com.example.collectionp1.сontroller;
import com.example.collectionp1.dto.Employee;
import com.example.collectionp1.service.StreamService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/departments")
public class StreamController {
    public final StreamService streamService;
    public StreamController(StreamService streamService) {
        this.streamService = streamService;
    }
    @GetMapping("/max-Salary")
    public Employee MaxSalaryByDepartment(@RequestParam int department) {
        return streamService.MaxSalaryByDepartment(department);
    }
    @GetMapping("/min-Salary")
    public Employee MinSalaryByDepartment(@RequestParam int department) {
        return streamService.MinSalaryByDepartment(department);
    }
    @GetMapping(path = "/all", params = {"department"})
    public Collection <Employee> getThemAllByDepartment(@RequestParam int department) {
        return streamService.getThemAllByDepartment(department);
    }
    @GetMapping("/all")
    public Map<Integer,List<Employee> > getThemAll() {
        return streamService.getThemAll();
    }
}