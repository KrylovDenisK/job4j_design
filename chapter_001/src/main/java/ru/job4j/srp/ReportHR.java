package ru.job4j.srp;

import java.util.Set;
import java.util.StringJoiner;
import java.util.TreeSet;
import java.util.function.Predicate;

public class ReportHR implements Report {
    private Store store;

    public ReportHR(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringJoiner text = new StringJoiner(System.lineSeparator()).add("Name; Salary");
        Set<Employee> set = new TreeSet<>(store.findBy(filter));
        for (Employee employee : set) {
            text.add(employee.getName() + "; " + employee.getSalary() + ";");
        }
        return text.toString();
    }
}
