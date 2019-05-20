package edu.dmacc.codedsm.payroll;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Employee> getEmployeeList() {
        return repository.getAllEmployee();
    }

    @Override
    public void updateEmployeeHours(Integer id, Double hours) {
        Employee employee = repository.getEmployee(id);
        if ( employee.getId() == id){
            employee.setHoursWorked(hours);
            repository.saveEmployee(employee);
        }
    }

    @Override
    public boolean findEmployee(Integer id) {
        if (repository.containsTheKey(id)) {
            return true;
        }
        else{
            return false;
        }
    }
}
