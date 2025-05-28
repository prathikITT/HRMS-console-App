
package service;

import model.Employee;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utils.InputUtils;
import utils.ValidationUtils;

import java.io.*;
import java.util.Scanner;

public class AdminService {

    private static final String EMPLOYEE_FILE = "data/employee_data.xlsx";

    public void addEmployee() {
        Scanner sc = InputUtils.getScanner();
        System.out.println("\n Enter Employee Details:");

        String id = InputUtils.readString("ID: ");
        String name = InputUtils.readString("Name: ");

        String email;
        while (true) {
            email = InputUtils.readString("Email: ");
            if (ValidationUtils.isValidEmail(email)) break;
            System.out.println(" Invalid email format.");
            if (!InputUtils.retryOrExitPrompt().equalsIgnoreCase("Y")) return;
        }

        String phone;
        while (true) {
            phone = InputUtils.readString("Phone (10 digits): ");
            if (ValidationUtils.isValidPhone(phone)) break;
            System.out.println(" Invalid phone number.");
            if (!InputUtils.retryOrExitPrompt().equalsIgnoreCase("Y")) return;
        }

        String gender;
        while (true) {
            gender = InputUtils.readString("Gender (Male/Female/Other): ");
            if (ValidationUtils.isValidGender(gender)) break;
            System.out.println(" Invalid gender input.");
            if (!InputUtils.retryOrExitPrompt().equalsIgnoreCase("Y")) return;
        }

        int age;
        while (true) {
            age = InputUtils.readInt("Age (18-60): ");
            if (ValidationUtils.isValidAge(age)) break;
            System.out.println(" Invalid age range.");
            if (!InputUtils.retryOrExitPrompt().equalsIgnoreCase("Y")) return;
        }

        String dob;
        while (true) {
            dob = InputUtils.readString("DOB (DD_MM_YYYY): ");
            if (ValidationUtils.isValidDOB(dob)) break;
            System.out.println(" Invalid DOB format.");
            if (!InputUtils.retryOrExitPrompt().equalsIgnoreCase("Y")) return;
        }

        String department = InputUtils.readString("Department: ");
        String designation = InputUtils.readString("Designation: ");
        String username = InputUtils.readString("Username (Employee ID): ");
        String password = InputUtils.readString("Password: ");

        Employee emp = new Employee(id, name, email, phone, gender, age, dob,
                department, designation, username, password);

        saveEmployeeToExcel(emp);
        System.out.println(" Employee added successfully.\n");
    }

    private void saveEmployeeToExcel(Employee emp) {
        File file = new File(EMPLOYEE_FILE);
        Workbook workbook;
        Sheet sheet;

        try {
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                workbook = new XSSFWorkbook(fis);
                sheet = workbook.getSheetAt(0);
                fis.close();
            } else {
                workbook = new XSSFWorkbook();
                sheet = workbook.createSheet("Employees");
                Row header = sheet.createRow(0);
                String[] headers = { "ID", "Name", "Email", "Phone", "Gender", "Age", "DOB",
                        "Department", "Designation", "Username", "Password" };
                for (int i = 0; i < headers.length; i++) {
                    header.createCell(i).setCellValue(headers[i]);
                }
            }

            int rowCount = sheet.getLastRowNum();
            Row row = sheet.createRow(rowCount + 1);
            row.createCell(0).setCellValue(emp.getId());
            row.createCell(1).setCellValue(emp.getName());
            row.createCell(2).setCellValue(emp.getEmail());
            row.createCell(3).setCellValue(emp.getPhone());
            row.createCell(4).setCellValue(emp.getGender());
            row.createCell(5).setCellValue(emp.getAge());
            row.createCell(6).setCellValue(emp.getDob());
            row.createCell(7).setCellValue(emp.getDepartment());
            row.createCell(8).setCellValue(emp.getDesignation());
            row.createCell(9).setCellValue(emp.getUsername());
            row.createCell(10).setCellValue(emp.getPassword());

            FileOutputStream fos = new FileOutputStream(file);
            workbook.write(fos);
            fos.close();
            workbook.close();
        } catch (IOException e) {
            System.out.println(" Error saving employee data: " + e.getMessage());
        }
    }
}