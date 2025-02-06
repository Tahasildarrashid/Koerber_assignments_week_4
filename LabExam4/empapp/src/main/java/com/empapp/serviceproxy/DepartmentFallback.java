package com.empapp.serviceproxy;

import com.empapp.dto.Department;
import com.empapp.service.EmployeeService;

public class DepartmentFallback implements DeptServiceProxy {
    @Override
    public Department getByName(String name) {
        return new Department(0, "Unknown Department", null);
    }
}
