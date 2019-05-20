package edu.dmacc.codedsm.payroll;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployeeList();
    void updateEmployeeHours(Integer id, Double hours);
    boolean findEmployee(Integer id);
}
