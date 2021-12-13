package com.example.G2.service;

import com.example.G2.Model.ActionResult;
import com.example.G2.Model.ActionResultStatus;
import com.example.G2.Model.EmployeeVote;
import com.example.G2.repository.EmployeeVoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeVoteService {
    @Autowired
    private EmployeeVoteRepository employeeVoteRepository;

    public ActionResult addVote(String employeeName) {
        Integer result = 1;
        if (isEmployeeExists(employeeName))
            result= employeeVoteRepository.updateVote(employeeName);
        else {
            var employeeVote =  EmployeeVote.create(employeeName);
            employeeVoteRepository.save(employeeVote);
        }
        var actionResult = ActionResult.create("Vote", "EmployeeVote", employeeName, result, ActionResultStatus.SUCCESS);
        return actionResult;
    }

    private boolean isEmployeeExists(String employeeName) {
        return employeeVoteRepository.findByEmployeeName(employeeName).size() > 0;
    }

    public List<EmployeeVote> findByEmployeeNames(List<String> names) {
        return employeeVoteRepository.findByEmployeeNameIn(names);
    }
}
