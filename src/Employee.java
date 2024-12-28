import java.util.Objects;

public class Employee {
    private static int counter = 0;
    private final int id;
    private String fullName;
    private int unit;
    private double salary;

    public Employee(String fullName, int unit, double salary) {
        this.id = ++counter;
        this.fullName = fullName;
        setUnit(unit);
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getUnit() {
        return unit;
    }

    public double getSalary() {
        return salary;
    }

    public void setUnit(int unit) {
        if (unit >= 1 && unit <= 5) {
            this.unit = unit;
        } else {
            throw new IllegalArgumentException("Номер подразделения должен быть от 1 до 5");
        }
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            throw new IllegalArgumentException("Зарплата не может быть отрицательной");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                unit == employee.unit &&
                Double.compare(employee.salary, salary) == 0 &&
                Objects.equals(fullName, employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, unit, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", unit=" + unit +
                ", salary=" + String.format("%.2f", salary) +
                '}';
    }
}
