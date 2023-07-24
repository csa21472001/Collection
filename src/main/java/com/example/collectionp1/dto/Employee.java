package com.example.collectionp1.dto;

import java.util.Objects;

public class Employee {

    private String fio;

    public Employee(String fio) {
        this.fio = fio;
    }

    public String getFio() {
        return fio;
    }
//    public void setSalary(double salary) {
//        if (salary < 0) {
//            System.out.println("Ошибка!!! ЗП не может быть отрицательной!");
//            return;
//        }
//        this.salary = salary;
//    }

//    public void setUnit(int unit) {
//        if (unit > 5 || unit < 1) {
//            System.out.println("Ошибка!!! Номер отдела от 1 до 5!");
//            return;
//        }
//        this.unit = unit;
//    }

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

