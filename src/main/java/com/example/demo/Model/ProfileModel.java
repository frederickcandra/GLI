package com.example.demo.Model;

import lombok.Data;

@Data
public class ProfileModel {
    public int id;
    public String name;
    public int age;
    private String gender;
}
