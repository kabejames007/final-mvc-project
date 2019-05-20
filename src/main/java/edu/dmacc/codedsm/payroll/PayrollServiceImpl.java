package edu.dmacc.codedsm.payroll;
import java.util.List;


public  class PayrollServiceImpl implements PayrollService {
    private EmployeeRepository repository;


    public PayrollServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void calculateNetPayFile() {
        Double netPay;
        Double grossPay;
        Double taxRate = 1.2;
        List<Employee> workers = repository.getAllEmployee();
        for (int i = 0; i < workers.size(); i++) {
            Employee e = workers.get(i);
            grossPay = e.getHourlyRate() * e.getHoursWorked();
            netPay = grossPay / taxRate;
            repository.savePayroll(e.getId(), e.getName(), netPay);
        }
    }
}
