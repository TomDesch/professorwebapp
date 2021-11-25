package com.switchfully.professorwebapp.api;

import com.switchfully.professorwebapp.api.dtos.CreateProfessorDto;
import com.switchfully.professorwebapp.api.dtos.ProfessorDto;
import com.switchfully.professorwebapp.domain.Professor;

public class ProfessorMapper {

    public ProfessorDto mapToDto(Professor savedProf) {
        return new ProfessorDto()
                .setFirstName(savedProf.getFirstName())
                .setLastName(savedProf.getLastName());
    }

    public Professor mapToProfessor(CreateProfessorDto createProfessorDto) {
        return new Professor(createProfessorDto.getFirstName(), createProfessorDto.getLastName());
    }
}
