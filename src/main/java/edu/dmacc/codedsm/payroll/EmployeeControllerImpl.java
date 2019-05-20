package edu.dmacc.codedsm.payroll;

public class EmployeeControllerImpl implements EmployeeController {
    private EmployeeService service;

    public EmployeeControllerImpl(EmployeeService service) {
        this.service = service;
    }


    @Override
    public void updatedEmployee(String inputId, String hours) {
        service.updateEmployeeHours(Integer.parseInt(inputId),Double.parseDouble(hours));

    }

    @Override
    public boolean foundEmployee(String inputId) {
        return service.findEmployee(Integer.parseInt(inputId));
    }

    @Override
    public AllEmployeeView getAllEmployee() {
        return new AllEmployeeViewImpl(service.getEmployeeList());
    }
}
