package com.example.G2.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

@Getter
@Setter
public class EmployeeVote {
    public String employeeName;
    @Id
    @GeneratedValue
    private Long Id;
    private int numberOfVotes;

    public EmployeeVote() {
    }

    public EmployeeVote(String employeeName, int numberOfVotes) {
        this.employeeName = employeeName;
        this.numberOfVotes = numberOfVotes;
    }

    public static EmployeeVote create(String EmployeeName) {
        return new EmployeeVote(EmployeeName, 1);
    }
}

