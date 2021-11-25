package com.switchfully.professorwebapp.api.dtos.professor;

public class UpdateProfessorDto {
    private String firstName;
    private String lastName;

    public UpdateProfessorDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UpdateProfessorDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
