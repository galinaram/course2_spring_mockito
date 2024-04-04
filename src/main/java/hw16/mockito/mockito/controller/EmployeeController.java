package hw16.mockito.mockito.controller;


import hw16.mockito.mockito.service.EmployeeService;
import hw16.mockito.mockito.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping
    public String test() {
        return "test";
    }
    @GetMapping("/add")
    public String add(@RequestParam("firstName") String firstName, @RequestParam("secondName") String secondName, @RequestParam("department") int department, @RequestParam("salary") double salary) {
        return employeeService.add(firstName, secondName, department, salary).toString();
    }
    @GetMapping("/delete")
    public String delete (@RequestParam("firstName") String firstName, @RequestParam("secondName") String secondName, @RequestParam("department") int department, @RequestParam("salary") double salary) {
        employeeService.remove(firstName, secondName, department, salary);
        return "done";
    }
    @GetMapping("/find")
    public String find (@RequestParam("firstName") String firstName, @RequestParam("secondName") String secondName, @RequestParam("department") int department, @RequestParam("salary") double salary) {
        return employeeService.find(firstName, secondName, department, salary).toString();
        //return "done";
    }
    @GetMapping("/all")
    public String printAll() {
        return employeeService.findAll().toString();
    }
}
