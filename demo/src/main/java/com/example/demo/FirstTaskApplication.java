package com.example.demo;

import com.example.demo.Entity.BankAccount;
import com.example.demo.Entity.Company;
import com.example.demo.Entity.Employee;
import com.example.demo.Entity.Individual;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class FirstTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstTaskApplication.class, args);

        String excelFilePath ="C:\\Users\\1\\Downloads\\demo\\demo\\src\\main\\java\\com\\example\\demo\\task1_table.xlsx";
        List<Employee> employees = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(excelFilePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);


            for (int i = 2; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                // Employee
                long id = (long) getNumericCellValue(row.getCell(0));
                String email = getStringCellValue(row.getCell(1));
                String phone = getStringCellValue(row.getCell(2));
                String address = getStringCellValue(row.getCell(3));

                // Bank Account
                String iban = getStringCellValue(row.getCell(13));
                String bic = getStringCellValue(row.getCell(14));
                String accountHolder = getStringCellValue(row.getCell(15));
                BankAccount bankAccount = new BankAccount(iban, bic, accountHolder);

                // Individual или Company
                if (row.getCell(5) != null && !getStringCellValue(row.getCell(5)).isEmpty()) {
                    String firstName = getStringCellValue(row.getCell(5));
                    String lastName = getStringCellValue(row.getCell(6));
                    boolean hasChildren = getBooleanCellValue(row.getCell(7));
                    int age = (int) getNumericCellValue(row.getCell(8));

                    Individual individual = new Individual(id, email, phone, address, bankAccount, firstName, lastName, hasChildren, age);
                    employees.add(individual);

                } else if (row.getCell(10) != null && !getStringCellValue(row.getCell(10)).isEmpty()) {
                    String companyName = getStringCellValue(row.getCell(10));
                    String type = getStringCellValue(row.getCell(11));
                    Company company = new Company(id, email, phone, address, bankAccount, companyName, type);
                    employees.add(company);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Employee employee : employees) {
            System.out.println(employee+"\n");
        }
    }

    private static String getStringCellValue(Cell cell) {
        if (cell == null)
            return "";
        if (cell.getCellType() == CellType.STRING) {
            return cell.getStringCellValue();
        } else if (cell.getCellType() == CellType.NUMERIC) {
            return String.valueOf((long) cell.getNumericCellValue());
        } else {
            return "";
        }
    }


    private static double getNumericCellValue(Cell cell) {
        if (cell == null)
            return 0;
        if (cell.getCellType() == CellType.NUMERIC) {
            return cell.getNumericCellValue();
        } else if (cell.getCellType() == CellType.STRING) {
            return Double.parseDouble(cell.getStringCellValue());
        } else {
            return 0;
        }
    }

    private static boolean getBooleanCellValue(Cell cell) {
        if (cell == null) return false;
        if (cell.getCellType() == CellType.BOOLEAN) {
            return cell.getBooleanCellValue();
        } else if (cell.getCellType() == CellType.STRING) {
            return Boolean.parseBoolean(cell.getStringCellValue());
        } else if (cell.getCellType() == CellType.NUMERIC) {
            return cell.getNumericCellValue() != 0;
        } else {
            return false;
        }
    }
}
