package hw16.mockito.mockito;

import hw16.mockito.mockito.service.DepartmentService;
import hw16.mockito.mockito.service.DepartmentServiceImpl;
import hw16.mockito.mockito.service.EmployeeService;
import hw16.mockito.mockito.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Null;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    private final Employee employee1 = new Employee("Ivan", "Ivanov", 1, 100);
    private final Employee employee2 = new Employee("Petr", "Petrov", 1, 200);
    private final Employee employee3 = new Employee("Petr", "Petrov", 2, 150);

    @Mock
    private EmployeeServiceImpl employeeServiceMock;
    @InjectMocks
    private DepartmentServiceImpl departmentService;
    @BeforeEach
    public void setUp(){
        Mockito.when(employeeServiceMock.fullList()).thenReturn(List.of(employee1, employee2, employee3));

    }
    @Test
    public void getMinSalaryInDepartmentTest(){
        Employee getMinSalaryInDepartment1 = departmentService.getMinSalaryInDepartment(employee1.getDepartment());
        assertThat(getMinSalaryInDepartment1).isEqualToIgnoringGivenFields(employee1, "id");
    }
    @Test
    public void getMaxSalaryInDepartmentTest(){
        Employee getMaxSalaryInDepartment1 = departmentService.getMaxSalaryInDepartment(employee1.getDepartment());
        assertThat(getMaxSalaryInDepartment1).isEqualToIgnoringGivenFields(employee2, "id");
    }
    @Test
    public void getFullDepTest(){
        Map<Integer, List<Employee>> fullListTest = Map.of(employee1.getDepartment(), List.of(employee1, employee2),
                employee3.getDepartment(), List.of(employee3));

        Map<Integer, List<Employee>> fullDep = departmentService.getFullDep();

        assertThat(fullListTest).containsExactlyInAnyOrderEntriesOf(fullDep);
    }

    @Test
    public void  getMinSalaryInDepartmentNotNull(){
        assertThrows(EmployeeNotFoundException.class, ()->departmentService.getMinSalaryInDepartment(100));
    }
    @Test
    public void  getMaxSalaryInDepartmentNotNull(){
        assertThrows(EmployeeNotFoundException.class, ()->departmentService.getMaxSalaryInDepartment(100));
    }
}
