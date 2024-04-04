package hw16.mockito.mockito.service;

import hw16.mockito.mockito.Employee;
import hw16.mockito.mockito.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeServiceImpl employeeServiceImpl;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }
    @Override
    public List<Employee> getDepartment(int department) {
        return employeeServiceImpl.fullList()
                .stream()
                .filter(employeesMap -> employeesMap.getDepartment() == department)
                .collect(Collectors.toList());
    }

    @Override
    public Employee getMaxSalaryInDepartment(int department) {
        return employeeServiceImpl.fullList()
                .stream()
                .filter(employeesMap -> employeesMap.getDepartment() == department)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Сотрудники отдела " + department + " не найдены"));
    }

    @Override
    public Employee getMinSalaryInDepartment(int department) {
        return employeeServiceImpl.fullList()
                .stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Сотрудники отдела " + department + " не найдены"));
    }

    @Override
    public Map<Integer, List<Employee>> getFullDep() {
        return employeeServiceImpl.fullList()
                .stream().collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
