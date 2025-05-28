package service;

import model.Employee;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EmployeeService {

    private static final String EMPLOYEE_FILE = "src/data/employee_data.xlsx";

    public static void saveEmployeeToExcel(Employee employee) {
        try {

            File directory = new File("data");
            if (!directory.exists()) {
                boolean created = directory.mkdirs();
                if (!created) {
                    System.out.println(" Failed to create directory: data");
                    return;
                }
            }

            Workbook workbook;
            Sheet sheet;

            File file = new File(EMPLOYEE_FILE);
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                workbook = new XSSFWorkbook(fis);
                sheet = workbook.getSheetAt(0);
            } else {
                workbook = new XSSFWorkbook();
                sheet = workbook.createSheet("Employees");

                Row header = sheet.createRow(0);
                header.createCell(0).setCellValue("Employee ID");
                header.createCell(1).setCellValue("Name");
                header.createCell(2).setCellValue("Email");
                header.createCell(3).setCellValue("Phone");
                header.createCell(4).setCellValue("Gender");
                header.createCell(5).setCellValue("Age");
                header.createCell(6).setCellValue("DOB");
                header.createCell(7).setCellValue("Department");
                header.createCell(8).setCellValue("Designation");
                header.createCell(9).setCellValue("Username");
                header.createCell(10).setCellValue("Password");
            }

            int lastRow = sheet.getLastRowNum() + 1;
            Row row = sheet.createRow(lastRow);

            row.createCell(0).setCellValue(employee.getId());
            row.createCell(1).setCellValue(employee.getName());
            row.createCell(2).setCellValue(employee.getEmail());
            row.createCell(3).setCellValue(employee.getPhone());
            row.createCell(4).setCellValue(employee.getGender());
            row.createCell(5).setCellValue(employee.getAge());
            row.createCell(6).setCellValue(employee.getDob());
            row.createCell(7).setCellValue(employee.getDepartment());
            row.createCell(8).setCellValue(employee.getDesignation());
            row.createCell(9).setCellValue(employee.getUsername());
            row.createCell(10).setCellValue(employee.getPassword());

            FileOutputStream fos = new FileOutputStream(EMPLOYEE_FILE);
            workbook.write(fos);
            workbook.close();
            fos.close();

            System.out.println(" Employee added successfully.");
        } catch (Exception e) {
            System.out.println(" Error saving employee data: " + e.getMessage());
        }
    }


    public void showDashboard(Employee employee) {
    }
}