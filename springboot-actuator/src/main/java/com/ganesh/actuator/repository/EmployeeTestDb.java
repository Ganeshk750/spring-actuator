package com.ganesh.actuator.repository;

/*
 * @created: 05/02/2021 - 3:18 PM
 * @author: Ganesh
 */


import com.ganesh.actuator.model.Employee;
import com.ganesh.actuator.model.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class EmployeeTestDb {

    public List<Employee> getAllEmployeeDetails(){
        return Stream.of(
                new Employee(1, "Ganesh", "ganesh@gmail.com", Profile.DEVELOPER, "active"),
                new Employee(2, "Deepak", "deepak@gmail.com", Profile.TESTER, "active"),
                new Employee(3, "Shashi", "shashi@gmail.com", Profile.DEVELOPER, "active"),
                new Employee(4, "Maya", "maya@gmail.com", Profile.HR, "active"),
                new Employee(5, "Aditya", "adi@gmail.com", Profile.DEVELOPER, "In-active"),
                new Employee(6, "Mike", "mike123@gmail.com", Profile.ADMIN, "active"),
                new Employee(7, "Joy", "joyee@gmail.com", Profile.TESTER, "In-active")
        ).collect(Collectors.toList());
    }

    public Long employeeStatusCountByStatus(String status) {
        return getAllEmployeeDetails().stream().filter(employee -> employee.getStatus().equals(status)).count();
    }

    public Long getEmployeeCountByProfile(String profile) {
      return getAllEmployeeDetails().stream().filter(employee -> employee.getProfile().toString().equals(profile)).count();
    }
}
