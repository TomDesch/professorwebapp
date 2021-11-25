package com.switchfully.professorwebapp.api;


import com.switchfully.professorwebapp.domain.Professor;
import com.switchfully.professorwebapp.api.dtos.ProfessorDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@RestController
@RequestMapping(path = "professors")
public class ProfessorController {
//    Make it so that we can:
//    Create a new professor.
//    Get all the professors.
//    Get the professor for a given id.
//    Update an existing professor (an id is provided) with a new set of data.
//    Delete an existing professor for a given id.
//    Create a specific service and the required domain objects to succeed in these requirements

//    Try to make use of DTO's (todo and dedicated mappers to map those DTO's from and to your domain objects).
//
//    Furthermore, think about todo edge-cases, e.g.:

    private ProfessorRepository professorRepository;
    private ProfessorMapper professorMapper;

    public ProfessorController(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
        this.professorMapper = new ProfessorMapper();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
    public ProfessorDto createProfessor() {
        Professor professor =
    }

}
