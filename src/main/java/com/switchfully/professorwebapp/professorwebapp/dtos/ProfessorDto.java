package com.switchfully.professorwebapp.professorwebapp.dtos;

public class ProfessorDto {
    private String id;
    private String firstName;
    private String lastName;

    public String getId() {
        return id;
    }

    public String getfirstName() {
        return firstName;
    }

    public String getlastName() {
        return lastName;
    }

    public ProfessorDto setId(String id) {
        this.id = id;
        return this;
    }

    public ProfessorDto setfirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ProfessorDto setlastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
