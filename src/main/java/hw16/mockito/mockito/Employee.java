package hw16.mockito.mockito;

public class Employee {
    private final String firstName;
    private final String secondName;
    private final int department;
    private final double salary;



    public Employee(String firstName, String secondName, int department, double salary) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.department = department;
        this.salary = salary;
    }

    public  String getFirstName() {
        return firstName;
    }
    public String getSecondName() {
        return secondName;
    }
    public int getDepartment(){
        return department;
    }
    public double getSalary() {
        return salary;
    }

    public String toString() {
        return "ФИО: " + getFirstName() + " " + getSecondName() + ", отдел: " + department + ", зарплата: " + salary;
    }

}