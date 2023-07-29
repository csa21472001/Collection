package com.example.collectionp1.dto;

import java.util.Objects;

public class Employee {

    private String fio;

    public Employee(String fio) {
        this.fio = fio;
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

