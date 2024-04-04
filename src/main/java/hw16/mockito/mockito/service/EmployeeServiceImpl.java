package hw16.mockito.mockito.service;

import hw16.mockito.mockito.Employee;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    Map<String, Employee> employeesMap = new HashMap<>();
    @Override
    public Employee add (String firstName, String secondName, int department, double salary) {
        Employee employee = new Employee(firstName, secondName, department, salary);
        if (employeesMap.containsKey(employee.toString())) {
            throw new RuntimeException();
        }
        employeesMap.put(employee.toString(), employee);
        return employee;
    }
    @Override
    public void remove (String firstName, String secondName, int department, double salary) {
        Employee employee = new Employee(firstName, secondName, department, salary);
        if (employeesMap.containsKey(employee.toString())) {
            employeesMap.remove(employee.toString());
            return;
        }
        throw new RuntimeException();
    }
    @Override
    public Employee find (String firstName, String secondName, int department, double salary) {
        Employee employee = new Employee(firstName, secondName, department, salary);
        if (employeesMap.containsKey(employee.toString())) {
            employeesMap.get(employee.toString());
            return employee;
        }
        throw new RuntimeException();
    }
    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employeesMap.values());
    }
    @Override
    public Collection<Employee> fullList() {
        return Collections.unmodifiableCollection(this.employeesMap.values());
    }
}
