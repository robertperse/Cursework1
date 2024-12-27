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

    private static class EmployeeBook {
        private Employee[] employees = new Employee[10];

        public boolean addEmployee(Employee employee) {
            for (int i = 0; i < employees.length; i++) {
                if (employees[i] == null) {
                    employees[i] = employee;
                    return true;
                }
            }
            return false;
        }

        public void removeEmployeeById(int id) {
            for (int i = 0; i < employees.length; i++) {
                if (employees[i] != null && employees[i].getId() == id) {
                    employees[i] = null;
                    return;
                }
            }
        }

        public Employee getEmployeeById(int id) {
            for (Employee employee : employees) {
                if (employee != null && employee.getId() == id) {
                    return employee;
                }
            }
            return null;
        }

        public void printAllEmployees() {
            for (Employee employee : employees) {
                if (employee != null) {
                    System.out.println(employee);
                }
            }
        }

        public void indexSalaries(double percent) {
            for (Employee employee : employees) {
                if (employee != null) {
                    double newSalary = employee.getSalary() * (1 + percent / 100);
                    employee.setSalary(newSalary);
                }
            }
        }

        public void indexSalariesInUnit(double percent, int unit) {
            for (Employee employee : employees) {
                if (employee != null && employee.getUnit() == unit) {
                    double newSalary = employee.getSalary() * (1 + percent / 100);
                    employee.setSalary(newSalary);
                }
            }
        }

        public void printEmployeesByUnit(int unit) {
            for (Employee employee : employees) {
                if (employee != null && employee.getUnit() == unit) {
                    System.out.println(employee);
                }
            }
        }

        public void printEmployeesWithSalaryLessThan(double amount) {
            for (Employee employee : employees) {
                if (employee != null && employee.getSalary() < amount) {
                    System.out.println(employee);
                }
            }
        }

        public void printEmployeesWithSalaryGreaterThanOrEqual(double amount) {
            for (Employee employee : employees) {
                if (employee != null && employee.getSalary() >= amount) {
                    System.out.println(employee);
                }
            }
        }

        public double getMinSalaryInUnit(int unit) {
            double minSalary = Double.MAX_VALUE;
            Employee minEmployee = null;

            for (Employee employee : employees) {
                if (employee != null && employee.getUnit() == unit) {
                    if (employee.getSalary() < minSalary) {
                        minSalary = employee.getSalary();
                        minEmployee = employee;
                    }
                }
            }
            return minEmployee != null ? minEmployee.getSalary() : 0;
        }

        public double getMaxSalaryInUnit(int unit) {
            double maxSalary = Double.MIN_VALUE;
            Employee maxEmployee = null;

            for (Employee employee : employees) {
                if (employee != null && employee.getUnit() == unit) {
                    if (employee.getSalary() > maxSalary) {
                        maxSalary = employee.getSalary();
                        maxEmployee = employee;
                    }
                }
            }
            return maxEmployee != null ? maxEmployee.getSalary() : 0;
        }

        public double getTotalSalaryByUnit(int unit) {
            double totalSalary = 0;

            for (Employee employee : employees) {
                if (employee != null && employee.getUnit() == unit) {
                    totalSalary += employee.getSalary();
                }
            }
            return totalSalary;
        }

        public double getAverageSalaryByUnit(int unit) {
            double totalSalary = 0;
            int count = 0;

            for (Employee employee : employees) {
                if (employee != null && employee.getUnit() == unit) {
                    totalSalary += employee.getSalary();
                    count++;
                }
            }
            return count > 0 ? totalSalary / count : 0;
        }
    }
}
