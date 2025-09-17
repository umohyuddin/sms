package com.smartsolutions.eschool.school.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DashBoardEntity {

    private int totalStudents;
    private int totalEmployees;
    private Long revenue;
    private Long remaining;
    private Long expenses;
    private Long remainingExpenses;


}
