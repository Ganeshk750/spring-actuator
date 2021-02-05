package com.ganesh.actuator.controller;

/*
 * @created: 05/02/2021 - 3:31 PM
 * @author: Ganesh
 */

import com.ganesh.actuator.model.Employee;
import com.ganesh.actuator.repository.EmployeeTestDb;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class EmployeeController {

    private EmployeeTestDb employeeTestDb;

    @GetMapping("/allUsers")
    public List<Employee> getAllEmployee(){
        return employeeTestDb.getAllEmployeeDetails();
    }
}
