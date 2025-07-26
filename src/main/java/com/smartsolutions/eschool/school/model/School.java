package com.smartsolutions.eschool.school.model;

import com.smartsolutions.eschool.school.campus.model.Campus;

import java.util.List;

public class School {
    private Long schoolId;
    private String name;
    private String address;
    private String contactNumber;
    private List<Campus> campuses;
}
