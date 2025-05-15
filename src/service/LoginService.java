package service;

import model.Admin;
import model.Employee;
import utils.InputUtils;

import java.util.List;

public class LoginService {

    public static Admin adminLogin(List<Admin> admins) {
        while (true) {
            String empId = InputUtils.getStringInput("Enter Admin Employee ID: ");
            String password = InputUtils.getStringInput("Enter Password: ");

            for (Admin admin : admins) {
                if (admin.getEmployeeId().equals(empId) && admin.getPassword().equals(password)) {
                    System.out.println("Admin Login Successful!\n");
                    return admin;
                }
            }

            System.out.println("Invalid Credentials! Try again or type 'exit' to go back.");
            String option = InputUtils.getStringInput("Enter choice: ");
            if (option.equalsIgnoreCase("exit")) {
                return null;
            }
        }
    }

    public static Employee employeeLogin(List<Employee> employees) {
        while (true) {
            String empId = InputUtils.getStringInput("Enter Employee ID: ");
            String password = InputUtils.getStringInput("Enter Password: ");

            for (Employee emp : employees) {
                if (emp.getEmployeeId().equals(empId) && emp.getPassword().equals(password)) {
                    System.out.println("Employee Login Successful!\n");
                    return emp;
                }
            }

            System.out.println("Invalid Credentials! Try again or type 'exit' to go back.");
            String option = InputUtils.getStringInput("Enter choice: ");
            if (option.equalsIgnoreCase("exit")) {
                return null;
            }
        }
    }
}