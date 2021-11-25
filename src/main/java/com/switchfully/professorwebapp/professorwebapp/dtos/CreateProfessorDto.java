package com.switchfully.professorwebapp.professorwebapp.dtos;

public class CreateProfessorDto {

    private String firstName;
    private int lastName;

    public CreateProfessorDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public CreateProfessorDto setLastName(int lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getLastName() {
        return lastName;
    }
}
