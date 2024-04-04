package hw16.mockito.mockito.controller;

import hw16.mockito.mockito.Employee;
import hw16.mockito.mockito.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping(params = "department", value = "/employees")
    public List<Employee> getFullDepartment(@RequestParam int department) {
        return departmentService.getDepartment(department);
    }


    @GetMapping(params = "department", value = "/max-salary")
    public Employee getMaxSalaryInDepartment(@RequestParam int department) {
        return departmentService.getMaxSalaryInDepartment(department);
    }

    @GetMapping("/min-salary")
    public Employee getMinSalaryInDepartment(@RequestParam int department) {
        return departmentService.getMinSalaryInDepartment(department);
    }
    @GetMapping("/employees")
    public Map<Integer, List<Employee>> getFullDep() {
        return departmentService.getFullDep();
    }
}

