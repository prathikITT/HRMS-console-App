//package service;
//
//import model.Admin;
//import model.Employee;
//import utils.InputUtils;
//
//import java.util.List;
//
//public class LoginService {
//
//    public static Admin adminLogin(List<Admin> admins) {
//        while (true) {
//            String empId = InputUtils.getStringInput("Enter Admin Employee ID: ");
//            String password = InputUtils.getStringInput("Enter Password: ");
//
//            for (Admin admin : admins) {
//                if (admin.getEmployeeId().equals(empId) && admin.getPassword().equals(password)) {
//                    System.out.println("Admin Login Successful!\n");
//                    return admin;
//                }
//            }
//
//            System.out.println("Invalid Credentials! Try again or type 'exit' to go back.");
//            String option = InputUtils.getStringInput("Enter choice: ");
//            if (option.equalsIgnoreCase("exit")) {
//                return null;
//            }
//        }
//    }
//
//    public static Employee employeeLogin(List<Employee> employees) {
//        while (true) {
//            String empId = InputUtils.getStringInput("Enter Employee ID: ");
//            String password = InputUtils.getStringInput("Enter Password: ");
//
//            for (Employee emp : employees) {
//                if (emp.getEmployeeId().equals(empId) && emp.getPassword().equals(password)) {
//                    System.out.println("Employee Login Successful!\n");
//                    return emp;
//                }
//            }
//
//            System.out.println("Invalid Credentials! Try again or type 'exit' to go back.");
//            String option = InputUtils.getStringInput("Enter choice: ");
//            if (option.equalsIgnoreCase("exit")) {
//                return null;
//            }
//        }
//    }
//}



package service;

import model.Employee;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utils.InputUtils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

public class LoginService {

    private static final String ADMIN_FILE = "src/data/admin_credentials.xlsx";
    private static final String EMPLOYEE_FILE = "src/data/employee_data.xlsx";

    public boolean loginAsAdmin() {
        String username = InputUtils.readString("Enter Admin Username: ");
        String password = InputUtils.readString("Enter Admin Password: ");

        try (FileInputStream fis = new FileInputStream(ADMIN_FILE);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            Row row = sheet.getRow(1); // assuming admin credentials are at row 1

            String storedUser = row.getCell(0).getStringCellValue();
            String storedPass = row.getCell(1).getStringCellValue();

            if (username.equals(storedUser) && password.equals(storedPass)) {
                return true;
            }

        } catch (Exception e) {
            System.out.println(" Error reading admin credentials: " + e.getMessage());
        }
        return false;
    }

    public Employee loginAsEmployee() {
        String username = InputUtils.readString("Enter Employee Username: ");
        String password = InputUtils.readString("Enter Password: ");

        File file = new File(EMPLOYEE_FILE);
        if (!file.exists()) {
            System.out.println(" Employee data not found.");
            return null;
        }

        try (FileInputStream fis = new FileInputStream(file);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();
            rows.next(); // skip header

            while (rows.hasNext()) {
                Row row = rows.next();
                String storedUsername = row.getCell(9).getStringCellValue();
                String storedPassword = row.getCell(10).getStringCellValue();

                if (username.equals(storedUsername) && password.equals(storedPassword)) {
                    return new Employee(
                            row.getCell(0).getStringCellValue(),
                            row.getCell(1).getStringCellValue(),
                            row.getCell(2).getStringCellValue(),
                            row.getCell(3).getStringCellValue(),
                            row.getCell(4).getStringCellValue(),
                            (int) row.getCell(5).getNumericCellValue(),
                            row.getCell(6).getStringCellValue(),
                            row.getCell(7).getStringCellValue(),
                            row.getCell(8).getStringCellValue(),
                            storedUsername,
                            storedPassword
                    );
                }
            }

        } catch (Exception e) {
            System.out.println(" Error reading employee data: " + e.getMessage());
        }

        System.out.println(" Invalid username or password.");
        return null;
    }
}