package com.ganesh.actuator.endpoints;

/*
 * @created: 05/02/2021 - 3:43 PM
 * @author: Ganesh
 */


import com.ganesh.actuator.repository.EmployeeTestDb;
import lombok.AllArgsConstructor;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@AllArgsConstructor
public class EmployeeStatusCountContributor implements InfoContributor {

    private EmployeeTestDb employeeTestDb;

    @Override
    public void contribute(Info.Builder builder) {
       Map<String, Long> employeeStatusMap = new HashMap<>();
       employeeStatusMap.put("active", employeeTestDb.employeeStatusCountByStatus("active"));
       employeeStatusMap.put("In-active", employeeTestDb.employeeStatusCountByStatus("In-active"));
       employeeStatusMap.put("DEVELOPER", employeeTestDb.getEmployeeCountByProfile("DEVELOPER"));
       employeeStatusMap.put("TESTER", employeeTestDb.getEmployeeCountByProfile("TESTER"));
       employeeStatusMap.put("HR", employeeTestDb.getEmployeeCountByProfile("HR"));
       builder.withDetail("employeeStatus", employeeStatusMap);
    }
}
