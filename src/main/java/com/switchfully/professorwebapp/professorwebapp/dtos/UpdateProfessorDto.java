package com.switchfully.professorwebapp.professorwebapp.dtos;

public class UpdateProfessorDto {
    private String firstName;
    private int lastName;

    public UpdateProfessorDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UpdateProfessorDto setLastName(int lastName) {
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
