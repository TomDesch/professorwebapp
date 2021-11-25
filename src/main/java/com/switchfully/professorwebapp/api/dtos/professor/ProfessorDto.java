package com.switchfully.professorwebapp.api.dtos.professor;

public class ProfessorDto {
    private String id;
    private String firstName;
    private String lastName;

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ProfessorDto setId(String id) {
        this.id = id;
        return this;
    }

    public ProfessorDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ProfessorDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
