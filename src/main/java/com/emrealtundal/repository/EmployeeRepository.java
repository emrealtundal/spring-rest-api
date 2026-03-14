package com.emrealtundal.repository;

import com.emrealtundal.model.Employee;
import com.emrealtundal.model.UpdateEmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

    @Autowired
    private List<Employee> employeeList;

    public List<Employee> getAllEmployeeList(){
        return employeeList;
    }

    public Employee getEmployeeById(String id){

        Employee findEmployee = null;
        for(Employee employee : employeeList){
            if(id.equals(employee.getId())){
                findEmployee = employee;
                break;
            }
        }
        return findEmployee;
    }

    public List<Employee> getEmployeeByFirstLetter(String firstLetter){
        List<Employee> findEmployees = new ArrayList<>();
        for(Employee employee : employeeList){
            if(employee.getFirstName().startsWith(firstLetter)){
                findEmployees.add(employee);
            }
        }
        return findEmployees;
    }

    public List<Employee> getEmployeeWithParams(String firstName, String lastName){
        List<Employee> employeeWithParams = new ArrayList<>();
        if(firstName == null && lastName == null){
            return employeeList;
        }

        for(Employee employee : employeeList){
            if(firstName != null && lastName != null){
                if(employee.getFirstName().equalsIgnoreCase(firstName) && employee.getLastName().equalsIgnoreCase(lastName)){
                    employeeWithParams.add(employee);
                }
            }

            else if(firstName != null && lastName == null){
                if(employee.getFirstName().equalsIgnoreCase(firstName)){
                    employeeWithParams.add(employee);
                }

            } else if (firstName == null && lastName != null) {
                if(employee.getLastName().equalsIgnoreCase(lastName)){
                    employeeWithParams.add(employee);
                }
            }
        }
        return employeeWithParams;
    }

    public Employee saveEmployee(Employee newEmployee){
        employeeList.add(newEmployee);
        return newEmployee;
    }

    public boolean deleteEmployee(String id){
        for (Employee employee : employeeList){
            if(employee.getId().equalsIgnoreCase(id)){
                employeeList.remove(employee);
                return true;
            }
        }
        return false;
    }

    public Employee findEmployeeById(String id){
        Employee findEmployee = null;
        for(Employee employee : employeeList){
            if(employee.getId().equals(id)){
                findEmployee = employee;
            }
        }
        return findEmployee;
    }

    public Employee updateEmployee(String id, UpdateEmployeeRequest request){
        Employee findEmployee = findEmployeeById(id);
        if(findEmployee != null){
            deleteEmployee(id);

            Employee updatedEmployee = new Employee();
            updatedEmployee.setId(id);
            updatedEmployee.setFirstName(request.getFirstName());
            updatedEmployee.setLastName(request.getLastName());

            employeeList.add(updatedEmployee);

            return updatedEmployee;
        }
        return null;
    }
}
