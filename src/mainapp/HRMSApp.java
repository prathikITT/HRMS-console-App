//package mainapp;
//
//import model.Admin;
//import model.Employee;
//import service.AdminService;
//import service.EmployeeService;
//import service.LoginService;
//import service.SignupService;
//import utils.InputUtils;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class HRMSApp {
//    private static List<Admin> admins = new ArrayList<>();
//    private static List<Employee> employees = new ArrayList<>();
//
//    public static void main(String[] args) {
//        while (true) {
//            System.out.println("----- Welcome to HRMS Application -----");
//            System.out.println("1. Admin");
//            System.out.println("2. Employee");
//            System.out.println("3. Exit");
//
//            int choice = InputUtils.getIntInput("Enter choice: ");
//
//            switch (choice) {
//                case 1:
//                    showAdminScreen();
//                    break;
//                case 2:
//                    showEmployeeScreen();
//                    break;
//                case 3:
//                    System.out.println("Thank you for using HRMS Application. Goodbye!");
//                    InputUtils.closeScanner();
//                    System.exit(0);
//                default:
//                    System.out.println("Invalid Choice. Try Again!\n");
//            }
//        }
//    }
//
//    private static void showAdminScreen() {
//        while (true) {
//            System.out.println("\n--- Admin Screen ---");
//            System.out.println("1. Login");
//            System.out.println("2. Signup");
//            System.out.println("3. Exit");
//
//            int choice = InputUtils.getIntInput("Enter choice: ");
//            switch (choice) {
//                case 1:
//                    Admin admin = LoginService.adminLogin(admins);
//                    if (admin != null) {
//                        showAdminDashboard();
//                    }
//                    break;
//                case 2:
//                    SignupService.adminSignup(admins);
//                    break;
//                case 3:
//                    return;
//                default:
//                    System.out.println("Invalid Choice. Try Again!\n");
//            }
//        }
//    }
//
//    private static void showAdminDashboard() {
//        while (true) {
//            System.out.println("\n--- Admin Dashboard ---");
//            System.out.println("1. Add Employee");
//            System.out.println("2. Logout");
//
//            int choice = InputUtils.getIntInput("Enter choice: ");
//            switch (choice) {
//                case 1:
//                    AdminService.addEmployee(employees);
//                    break;
//                case 2:
//                    return;
//                default:
//                    System.out.println("Invalid Choice. Try Again!\n");
//            }
//        }
//    }
//
//    private static void showEmployeeScreen() {
//        Employee employee = LoginService.employeeLogin(employees);
//        if (employee != null) {
//            EmployeeService.showEmployeeDashboard();
//        }
//    }
//}



package mainapp;

import model.Employee;
import service.AdminService;
import service.EmployeeService;
import service.LoginService;
import utils.InputUtils;

public class HRMSApp {
    public static void main(String[] args) {
        LoginService loginService = new LoginService();
        AdminService adminService = new AdminService();
        EmployeeService employeeService = new EmployeeService();

        while (true) {
            System.out.println("\n==== HRMS Main Menu ====");
            System.out.println("1. Admin Login");
            System.out.println("2. Employee Login");
            System.out.println("3. Exit");
            String choice = InputUtils.readString("Choose an option: ");

            switch (choice) {
                case "1":
                    if (loginService.loginAsAdmin()) {
                        System.out.println(" Admin login successful.");
                        boolean adminMenu = true;
                        while (adminMenu) {
                            System.out.println("\n Admin Dashboard:");
                            System.out.println("1. Add Employee");
                            System.out.println("2. Logout");
                            String adminChoice = InputUtils.readString("Choose an option: ");
                            switch (adminChoice) {
                                case "1":
                                    adminService.addEmployee();
                                    break;
                                case "2":
                                    adminMenu = false;
                                    break;
                                default:
                                    System.out.println(" Invalid option.");
                            }
                        }
                    } else {
                        System.out.println(" Admin login failed.");
                    }
                    break;

                case "2":
                    Employee employee = loginService.loginAsEmployee();
                    if (employee != null) {
                        employeeService.showDashboard(employee);
                    }
                    break;

                case "3":
                    System.out.println(" Exiting. Thank you");
                    System.exit(0);
                    break;

                default:
                    System.out.println(" Invalid choice. Please try again.");
            }
        }
    }
}




//package mainapp;
//
//import model.Employee;
//import service.AdminService;
//import service.EmployeeService;
//import service.LoginService;
//import utils.InputUtils;
//
//public class HRMSApp {
//    public static void main(String[] args) {
//        LoginService loginService = new LoginService();
//        AdminService adminService = new AdminService();
//        EmployeeService employeeService = new EmployeeService();
//
//        while (true) {
//            System.out.println("\n--- HRMS MENU ---");
//            System.out.println("1. Admin Login");
//            System.out.println("2. Employee Login");
//            System.out.println("3. Exit");
//
//            int choice = InputUtils.readInt("Enter choice: ");
//
//            switch (choice) {
//                case 1:
//                    if (loginService.loginAsAdmin()) {
//                        System.out.println("✅ Admin logged in.");
//                        adminService.addEmployee();
//                    } else {
//                        System.out.println("❌ Admin login failed.");
//                    }
//                    break;
//                case 2:
//                    Employee emp = loginService.loginAsEmployee();
//                    if (emp != null) {
//                        employeeService.showDashboard(emp);
//                    } else {
//                        System.out.println("❌ Invalid employee credentials.");
//                    }
//                    break;
//                case 3:
//                    System.out.println("Goodbye!");
//                    return;
//                default:
//                    System.out.println("Invalid choice.");
//            }
//        }
//    }
//}
