package edu.dmacc.codedsm.payroll;

public interface EmployeeController {
    void updatedEmployee(String inputId, String hours);
    boolean foundEmployee(String inputID);
    AllEmployeeView getAllEmployee();
}
