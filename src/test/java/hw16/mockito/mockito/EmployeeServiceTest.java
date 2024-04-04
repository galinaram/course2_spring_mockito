package hw16.mockito.mockito;

import hw16.mockito.mockito.service.EmployeeService;
import hw16.mockito.mockito.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class EmployeeServiceTest {
    @Autowired
    private EmployeeService employeeService;
    @Test
    public void addTest() {
        String firstName = "firstName";
        String secondName = "secondName";
        int department = 1;
        double salary = 0;

        Employee add = employeeService.add(firstName, secondName, department, salary);

        Assertions.assertEquals(add.getFirstName(), firstName);
        Assertions.assertEquals(add.getSecondName(), secondName);
        Assertions.assertEquals(add.getDepartment(), department);
        Assertions.assertEquals(add.getSalary(), salary);
    }
    @Test
    public void removeTest(){
        Employee add = employeeService.add("firstName", "secondName", 1, 0);

        employeeService.remove(add.getFirstName(), add.getSecondName(), add.getDepartment(), add.getSalary());

        assertThrows(RuntimeException.class, ()-> employeeService.find(add.getFirstName(),add.getSecondName(), add.getDepartment(), add.getSalary()));
    }
    @Test
    public void findTest(){
        Employee add = employeeService.add("firstName", "secondName", 1, 0);
        Employee find = employeeService.find(add.getFirstName(), add.getSecondName(), add.getDepartment(), add.getSalary());
        Assertions.assertEquals(add.getFirstName(), find.getFirstName());
        Assertions.assertEquals(add.getSecondName(), find.getSecondName());
        Assertions.assertEquals(add.getDepartment(), find.getDepartment());
        Assertions.assertEquals(add.getSalary(), find.getSalary());
    }
    @Test
    public void  findNotNull(){
        assertThrows(RuntimeException.class, ()-> employeeService.find("","", 1, 0));
    }
}
