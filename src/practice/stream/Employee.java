package practice.stream;

public class Employee {
    private String name;
    private Double Salary;
    private String Department;

    public Employee(String name, Double salary, String department) {
        this.name = name;
        Salary = salary;
        Department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return Salary;
    }

    public void setSalary(Double salary) {
        Salary = salary;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }
}
