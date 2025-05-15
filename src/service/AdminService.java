package service;

import model.Employee;
import utils.InputUtils;

import java.util.List;

public class AdminService {

    public static void addEmployee(List<Employee> employees) {
        System.out.println("\n--- Add New Employee ---");

        String name = InputUtils.getStringInput("Enter Employee Name: ");
        String empId = InputUtils.getStringInput("Enter Employee ID: ");
        String email = InputUtils.getStringInput("Enter Email: ");
        String password = InputUtils.getStringInput("Create Password: ");

        Employee employee = new Employee(empId, name, email, password);
        employees.add(employee);

        System.out.println("Employee added successfully!\n");
    }
}