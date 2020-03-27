package ru.job4j.srp;

import java.util.StringJoiner;
import java.util.function.Predicate;

public class ReportIT implements Report {
    private Store store;

    public ReportIT(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringJoiner text = new StringJoiner(System.lineSeparator()).add("<!DOCTYPE html>")
                .add("<html>").add("<head>").add("<title>ReportIT</title>").add("</head>")
                .add("<body>").add("<table>").add("Name; Hired; Fired; Salary");
        for (Employee employee : store.findBy(filter)) {
            text.add("<tr>" + employee.getName() + ";" + employee.getHired() + ";"
                    + employee.getFired() + ";" + employee.getSalary() + ";");
        }
        text.add("</table>").add("</body>").add("</html>");
        return text.toString();
    }
}
