package edu.dmacc.codedsm.payroll;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataLoaderServiceImpl implements DataLoaderService {

    private EmployeeRepository repository;

    public DataLoaderServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void employeeFileReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "initial_load.txt"));
            String line = reader.readLine();
            while (line != null) {
                repository.saveEmployee(createEmployee(line));
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee createEmployee(String employeeFile) {
        Employee employee = new Employee(Integer.parseInt(employeeFile.split(",")[0]), employeeFile.split(",")[1], Double.parseDouble(employeeFile.split(",")[2]), 0.0);
        return employee;
    }
}
