package com.example.G2.service;

import com.example.G2.Model.Employee;
import com.example.G2.Model.EmployeeVote;
import com.example.G2.Model.Error;
import com.example.G2.exception.APIIntegrationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Value("${g2.crowd.uri}")
    private String g2CrowdURL;

    @Autowired
    private EmployeeVoteService employeeVoteService;

    private List<Employee> getAllEmployees() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            var employees = Arrays.asList(restTemplate.getForObject(g2CrowdURL, Employee[].class));
            return employees;
        } catch (RuntimeException ex) {
            var error = Error.create("Error on invoking URL: " + g2CrowdURL, "Get Employees");
            throw new APIIntegrationException(error);
        }

    }

    public List<Employee> getEmployees() {
        List<Employee> employees = getAllEmployees();
        updateVotes(employees);
        return employees;
    }

    private void updateVotes(List<Employee> employees) {
        List<String> employeeNames = employees.stream().map(employee -> employee.name).collect(Collectors.toList());
        List<EmployeeVote> employeeVotes = employeeVoteService.findByEmployeeNames(employeeNames);
        employees.forEach(employee ->
        {
            var vote = employeeVotes.stream().filter(employeeVote -> employeeVote.employeeName.compareTo(employee.name) == 0).findFirst();
            if (vote.isPresent())
                employee.setNumberOfVotes(vote.get().getNumberOfVotes());
        });
    }


}

