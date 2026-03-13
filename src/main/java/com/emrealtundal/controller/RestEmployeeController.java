package com.emrealtundal.controller;

import com.emrealtundal.model.Employee;
import com.emrealtundal.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/employee")
public class RestEmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(path = "/list")
    public List<Employee> getAllEmployeeList(){
        employeeService.getAllEmployeeList();

        return employeeService.getAllEmployeeList();
    }


    @GetMapping(path = "/list/{id}")
    public Employee getEmployeeById(@PathVariable(name = "id" , required = true) String id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping(path = "/list/finderbyletter/{firstLetter}")
    public List<Employee> getEmployeeByFirstName(@PathVariable(name = "firstLetter", required = true) String firstLetter){
        return employeeService.getEmployeeByFirstLetter(firstLetter);
    }

    @GetMapping(path = "/with-params")
    public List<Employee> getEmployeesWithParams(@RequestParam(name = "firstName", required = false) String firstName,
                                                 @RequestParam(name = "lastName", required = false) String lastName
                                                 ){

        System.out.println(firstName + " " + lastName);
        return employeeService.getEmployeeWithParams(firstName, lastName);
    }

    @PostMapping(path = "/save-employee")
    public Employee saveEmployee(@RequestBody Employee newEmployee){

        return employeeService.saveEmployee(newEmployee);
    }

    @DeleteMapping(path = "/delete-employee/{id}")
    public boolean deleteEmployee(@PathVariable(name = "id") String id){
        return employeeService.deleteEmployee(id);
    }

}
