public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();

        employeeBook.addEmployee(new Employee("Иван Иванов", 1, 84000));
        employeeBook.addEmployee(new Employee("Петр Петров", 1, 91000));
        employeeBook.addEmployee(new Employee("Светлана Смирнова", 2, 74000));
        employeeBook.addEmployee(new Employee("Анна Кузнецова", 2, 66000));
        employeeBook.addEmployee(new Employee("Василий Князев", 3, 75000));
        employeeBook.addEmployee(new Employee("Екатерина Зверева", 3, 68000));
        employeeBook.addEmployee(new Employee("Лариса Борисова", 4, 71000));
        employeeBook.addEmployee(new Employee("Владислав Козинцев", 4, 63000));
        employeeBook.addEmployee(new Employee("Варвара Соколова", 5, 69000));
        employeeBook.addEmployee(new Employee("Геннадий Горин", 5, 76000));

        System.out.println("Все сотрудники:");
        employeeBook.printAllEmployees();

        employeeBook.indexSalaries(10);
        System.out.println("\nПосле индексации зарплат:");
        employeeBook.printAllEmployees();

        System.out.println("\nСотрудники подразделения 1:");
        employeeBook.printEmployeesByUnit(1);

        System.out.println("\nСотрудники с зарплатой меньше 80000:");
        employeeBook.printEmployeesWithSalaryLessThan(80000);

        System.out.println("\nСотрудники с зарплатой больше или равной 80000:");
        employeeBook.printEmployeesWithSalaryGreaterThanOrEqual(80000);

        System.out.println("\nМинимальная зарплата в отделе 2: " + employeeBook.getMinSalaryInUnit(2));
        System.out.println("Максимальная зарплата в отделе 2: " + employeeBook.getMaxSalaryInUnit(2));
        System.out.println("Сумма затрат на зарплаты в отделе 2: " + employeeBook.getTotalSalaryByUnit(2));
        System.out.println("Средняя зарплата в отделе 2: " + employeeBook.getAverageSalaryByUnit(2));
        employeeBook.indexSalariesInUnit(10, 2);
        employeeBook.printEmployeesByUnit(2);

        employeeBook.removeEmployeeById(2);
        System.out.println("\nПосле удаления сотрудника с ID 2:");
        employeeBook.printAllEmployees();
    }
}
