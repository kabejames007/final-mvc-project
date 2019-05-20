package edu.dmacc.codedsm.payroll;

import java.util.List;

public class AllEmployeeViewImpl implements AllEmployeeView {
    private List<Employee> employees;

    public AllEmployeeViewImpl(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public void render() {
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.printf("%5s %25s %25s %25s ", "ID", "NAMES", "HOURLY RATE", "WORKED HOURS");
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------- ");
        for (int i = 0 ; i < employees.size(); i++){
            System.out.format("%5s %25s %20s %25s", employees.get(i).getId(),employees.get(i).getName(), employees.get(i).getHourlyRate(), employees.get(i).getHoursWorked());
            System.out.println();
        }
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("                                       ");
    }
}
