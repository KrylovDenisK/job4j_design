package ru.job4j.srp;

import java.util.Calendar;
import java.util.Objects;

public class Employee implements Comparable<Employee> {
    private String name;
    private Calendar hired;
    private Calendar fired;
    private int salary;

    public Employee(String name, Calendar hired, Calendar fired, int salary) {
        this.name = name;
        this.hired = hired;
        this.fired = fired;
        this.salary = salary;
    }

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getHired() {
        return hired;
    }

    public void setHired(Calendar hired) {
        this.hired = hired;
    }

    public Calendar getFired() {
        return fired;
    }

    public void setFired(Calendar fired) {
        this.fired = fired;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employer = (Employee) o;
        return Objects.equals(name, employer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Employee o) {
        return salary - o.getSalary();
    }
}
