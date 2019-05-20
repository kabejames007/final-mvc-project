package edu.dmacc.codedsm.payroll;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    private Map<Integer, Employee> employeeDatabase = new HashMap<>();
    private PrintWriter out = null;

    @Override
    public List<Employee> getAllEmployee() {
        return new ArrayList<>(employeeDatabase.values());
    }

    @Override
    public Employee getEmployee(Integer id) {
        return employeeDatabase.get(id);
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeDatabase.put(employee.getId(),employee);
    }

    @Override
    public boolean containsTheKey(Integer id) {
        if (employeeDatabase.containsKey(id)) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void savePayroll(Integer employeeId, String name, Double netPay) {
        try {
            out = new PrintWriter(
                    new BufferedWriter(
                            new FileWriter("payroll_results.txt", true)));
            out.println(employeeId + " " + name + " " + String.format("%.2f",netPay));
        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
