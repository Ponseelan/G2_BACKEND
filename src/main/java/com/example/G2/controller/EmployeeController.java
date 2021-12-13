package com.example.G2.controller;

import com.example.G2.Model.ActionResult;
import com.example.G2.Model.Employee;
import com.example.G2.service.EmployeeService;
import com.example.G2.service.EmployeeService;
import com.example.G2.service.EmployeeVoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeVoteService employeeVoteService;
    @GetMapping("/employee")
    List<Employee> getAll()
    {
        return employeeService.getEmployees();
    }

    @PostMapping("/employee/{employeeName}/vote")
    ActionResult  addVote(@PathVariable String employeeName)
    {
       return employeeVoteService.addVote(employeeName);
    }
}
