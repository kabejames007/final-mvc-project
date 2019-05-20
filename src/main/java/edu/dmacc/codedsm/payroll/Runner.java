package edu.dmacc.codedsm.payroll;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {

        EmployeeRepository repository = new EmployeeRepositoryImpl();
        DataLoaderService service = new DataLoaderServiceImpl(repository);
        DataLoaderController controller = new DataLoaderControllerImpl(service);
        controller.initial_load();

        EmployeeService service_emp = new EmployeeServiceImpl(repository);
        EmployeeController controller_emp = new EmployeeControllerImpl(service_emp);
        AllEmployeeView view = controller_emp.getAllEmployee();


        PayrollService service_payroll = new PayrollServiceImpl(repository);
        PayrollController controller_pay = new PayrollControllerImpl(service_payroll);

        app(view,controller_emp, controller_pay);

    }

    private static void app(AllEmployeeView viewer, EmployeeController controller_empl, PayrollController controller_pay){
        while (true) {
            String list = "Type L to List all known Employees:";
            String update = "Type U to update employee's hours:";
            String process = "Type P to process payroll:";
            String exit_program = "Type E to exit the program:";
            Scanner in = new Scanner(System.in);
            System.out.println(list + "\n" + update + "\n" + process + "\n" + exit_program);
            String input = in.next();
            if (input.equalsIgnoreCase("L")) {
                viewer.render();
            }else if (input.equalsIgnoreCase("U")) {
                Scanner inUpdate = new Scanner(System.in);
                System.out.print("Enter the employee ID to update: ");
                String inputId = inUpdate.next();
                if (inputId != null && isNumeric(inputId)) {
                    if (controller_empl.foundEmployee(inputId)) {
                        Scanner inputHours = new Scanner(System.in);
                        System.out.print("Update the hours employee worked: ");
                        String hoursWorked = inputHours.next();
                        if (isNumeric(hoursWorked)) {
                            controller_empl.updatedEmployee(inputId, hoursWorked);
                        }else {
                            System.out.println("You must enter a valid number for hours worked.");
                            System.out.println("Valid numbers are whole numbers or whole numbers with decimals.");
                            System.out.println("                                       ");
                        }
                    }else {
                        System.out.println("Employee not found");
                        System.out.println("                                       ");
                    }
                } else {
                    System.out.println("Invalid input");
                    System.out.println("                                       ");
                }
            }else if (input.equalsIgnoreCase("P")) {
                controller_pay.processPayroll();
                System.exit(0);
            }else if (input.equalsIgnoreCase("E")) {
                System.exit(0);
            }else {
                System.out.println("Not allowed character");
                System.out.println("                                       ");
            }
        }
    }
    private static boolean isNumeric(String strNum) {
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }
}
