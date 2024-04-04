package hw16.mockito.mockito.service;

import hw16.mockito.mockito.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    List<Employee> getDepartment (int department);
    Employee getMaxSalaryInDepartment(int department);

    Employee getMinSalaryInDepartment(int department);

    Map<Integer, List<Employee>> getFullDep();
}
