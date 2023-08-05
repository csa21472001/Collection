package com.example.collectionp1.dto;

import java.util.Objects;

public class Employee {

    private String fio;
    private int department;
    private double salary;

    public Employee(int department,String fio,double salary) {
        this.fio = fio;
        this.department = department;
        this.salary = salary;
    }
    public Employee(String fio) {
        this.fio = fio;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(fio, employee.fio);
    }

    @Override
    public String toString() {
        return "Id сотрудника - " + ". ФИО сотрудника - " + this.fio + ". Номер отдела - " + ". Зарплата - " + ".";
    }


}

