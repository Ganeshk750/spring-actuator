package com.ganesh.actuator.model;

/*
 * @created: 05/02/2021 - 3:14 PM
 * @author: Ganesh
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private int id;
    private String name;
    private String email;
    private Profile profile;
    private String status;
}
