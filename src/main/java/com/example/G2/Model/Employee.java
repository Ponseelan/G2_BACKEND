package com.example.G2.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Getter
@Setter
public class Employee  {
    public long id;
    public String name;
    public  String title;
    public String bio;
    public String image_url;
    public int numberOfVotes;
}
