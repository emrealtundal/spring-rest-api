package com.emrealtundal.config;


import com.emrealtundal.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public List<Employee> employeeList(){
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("1","Enes","Bayram"));
        employeeList.add(new Employee("2","Emre","Altundal"));
        employeeList.add(new Employee("3","Melisa","Aytaç"));
        employeeList.add(new Employee("4","Lebron","James"));
        employeeList.add(new Employee("5","Hyengeu","Oh"));
        employeeList.add(new Employee("6","Melisa","Altundal"));
        employeeList.add(new Employee("7","Aykut","Elmas"));
        employeeList.add(new Employee("8","Melih","Abuaf"));

        return employeeList;
    }
}
