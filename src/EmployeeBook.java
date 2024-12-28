class EmployeeBook {
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