
package com.example.tdd.salary;

public class Employee {

    private String name;
    private String email;
    private double baseSalary;
    private Role role;

    public Employee(String name, String email, double baseSalary, Role role) {
        this.name = name;
        this.email = email;
        this.baseSalary = baseSalary;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public Role getRole() {
        return role;
    }
}
