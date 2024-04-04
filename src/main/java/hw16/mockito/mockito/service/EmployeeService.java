package hw16.mockito.mockito.service;

import hw16.mockito.mockito.Employee;

import java.util.*;

public interface EmployeeService {

    Employee add(String firstName, String secondName, int department, double salary);

    void remove(String firstName, String secondName, int department, double salary);

    Employee find(String firstName, String secondName, int department, double salary);

    Collection<Employee> findAll();
    Collection<Employee> fullList();
}