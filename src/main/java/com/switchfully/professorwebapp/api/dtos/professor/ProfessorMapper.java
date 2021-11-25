package com.switchfully.professorwebapp.api.dtos.professor;

import com.switchfully.professorwebapp.domain.professor.Professor;

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
