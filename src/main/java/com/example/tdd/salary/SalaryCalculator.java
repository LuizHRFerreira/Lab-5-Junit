
package com.example.tdd.salary;

public class SalaryCalculator {

    public double calculate(Employee employee) {

        double salary = employee.getBaseSalary();

        return switch (employee.getRole()) {

            case DESENVOLVEDOR -> salary >= 3000 ? salary * 0.8 : salary * 0.9;

            case DBA, TESTADOR -> salary >= 2000 ? salary * 0.75 : salary * 0.85;

            case GERENTE -> salary >= 5000 ? salary * 0.7 : salary * 0.8;
        };
    }
}
