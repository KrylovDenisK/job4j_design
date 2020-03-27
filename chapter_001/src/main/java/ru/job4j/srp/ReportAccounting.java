package ru.job4j.srp;

import java.util.StringJoiner;
import java.util.function.Predicate;

public class ReportAccounting implements Report {
    private Store store;

    public ReportAccounting(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringJoiner text = new StringJoiner(System.lineSeparator()).add("Name; Hired; Fired; Salary");
        for (Employee employee : store.findBy(filter)) {
            text.add(employee.getName() + "; " + employee.getHired() + "; "
                    + employee.getFired() + "; " + employee.getSalary() / 60  + ";");
        }
        return text.toString();
    }
}
