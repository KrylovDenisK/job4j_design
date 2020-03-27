package ru.job4j.srp;
import java.util.StringJoiner;
import java.util.function.Predicate;

public class ReportEngine implements Report {
    private Store store;

    public ReportEngine(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employee> filter) {
        StringJoiner text = new StringJoiner(System.lineSeparator()).add("Name; Hired; Fired; Salary");
        for (Employee employee : store.findBy(filter)) {
            text.add(employee.getName() + "; "
                    + employee.getHired() + "; " + employee.getFired() + "; "
                    + employee.getSalary() + ";");
        }
        return text.toString();
    }




}
