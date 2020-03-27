package ru.job4j.srp;

import org.junit.Test;

import java.util.Calendar;
import java.util.StringJoiner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReportEngineTest {
    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringJoiner expected = new StringJoiner(System.lineSeparator()).add("Name; Hired; Fired; Salary")
                .add(worker.getName() + "; " + worker.getHired() + "; "
                        + worker.getFired() + "; " + worker.getSalary() + ";");
        String result = engine.generate(em -> true);
        assertThat(result, is(expected.toString()));
    }

    @Test
    public void whenHRGenerated() {
        MemStore store = new MemStore();
        Employee worker = new Employee("Ivan", 600);
        store.add(worker);
        Report engine = new ReportHR(store);
        StringJoiner expected = new StringJoiner(System.lineSeparator()).add("Name; Salary")
                .add(worker.getName() + "; " + worker.getSalary() + ";");
        assertThat(engine.generate(em -> true), is(expected.toString()));
    }

    @Test
    public void whenAccoutingGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 600);
        store.add(worker);
        Report engine = new ReportAccounting(store);
        StringJoiner expected = new StringJoiner(System.lineSeparator()).add("Name; Hired; Fired; Salary")
                .add(worker.getName() + "; " + worker.getHired() + "; "
                        + worker.getFired() + "; " + worker.getSalary() / 60  + ";");
        String result = engine.generate(em -> true);
        assertThat(result, is(expected.toString()));

    }

    @Test
    public void whenITReport() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 600);
        store.add(worker);
        Report engine = new ReportIT(store);
        StringJoiner expected = new StringJoiner(System.lineSeparator()).add("<!DOCTYPE html>")
                .add("<html>").add("<head>").add("<title>ReportIT</title>").add("</head>")
                .add("<body>").add("<table>").add("Name; Hired; Fired; Salary")
                .add("<tr>" + worker.getName() + ";" + worker.getHired() + ";" + worker.getFired() + ";" + worker.getSalary() + ";")
                .add("</table>").add("</body>").add("</html>");
        assertThat(engine.generate(em -> true), is(expected.toString()));
        }
}