
package com.example.tdd.salary;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SalaryCalculatorTest {

    private final SalaryCalculator calculator = new SalaryCalculator();

    @Test
    void shouldCreateEmployeeWithAllFields() {

        Employee employee =
                new Employee("Joao", "joao@email.com",
                        3000, Role.DESENVOLVEDOR);

        assertEquals("Joao", employee.getName());
        assertEquals("joao@email.com", employee.getEmail());
        assertEquals(3000, employee.getBaseSalary());
        assertEquals(Role.DESENVOLVEDOR, employee.getRole());
    }

    @Test
    void shouldApply20PercentDiscountForDeveloperAbove3000() {

        Employee employee =
                new Employee("Joao", "joao@email.com",
                        3000, Role.DESENVOLVEDOR);

        assertEquals(2400, calculator.calculate(employee));
    }

    @Test
    void shouldApply10PercentDiscountForDeveloperBelow3000() {

        Employee employee =
                new Employee("Joao", "joao@email.com",
                        2000, Role.DESENVOLVEDOR);

        assertEquals(1800, calculator.calculate(employee));
    }

    @Test
    void shouldApply25PercentDiscountForDBAAbove2000() {

        Employee employee =
                new Employee("Maria", "maria@email.com",
                        2000, Role.DBA);

        assertEquals(1500, calculator.calculate(employee));
    }

    @Test
    void shouldApply15PercentDiscountForDBABelow2000() {

        Employee employee =
                new Employee("Maria", "maria@email.com",
                        1000, Role.DBA);

        assertEquals(850, calculator.calculate(employee));
    }

    @Test
    void shouldApply25PercentDiscountForTesterAbove2000() {

        Employee employee =
                new Employee("Carlos", "carlos@email.com",
                        2500, Role.TESTADOR);

        assertEquals(1875, calculator.calculate(employee));
    }

    @Test
    void shouldApply15PercentDiscountForTesterBelow2000() {

        Employee employee =
                new Employee("Carlos", "carlos@email.com",
                        1500, Role.TESTADOR);

        assertEquals(1275, calculator.calculate(employee));
    }

    @Test
    void shouldApply30PercentDiscountForManagerAbove5000() {

        Employee employee =
                new Employee("Ana", "ana@email.com",
                        5000, Role.GERENTE);

        assertEquals(3500, calculator.calculate(employee));
    }

    @Test
    void shouldApply20PercentDiscountForManagerBelow5000() {

        Employee employee =
                new Employee("Ana", "ana@email.com",
                        4000, Role.GERENTE);

        assertEquals(3200, calculator.calculate(employee));
    }
}
