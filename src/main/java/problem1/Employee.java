package problem1;

import java.util.Objects;

public class Employee extends Person {
    private final String role;
    public Employee(String name, int age, String role) {
        super(name, age);
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(role, employee.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role);
    }
}