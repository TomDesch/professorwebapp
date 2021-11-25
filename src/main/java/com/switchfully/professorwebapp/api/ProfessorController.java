package com.switchfully.professorwebapp.api;


import com.switchfully.professorwebapp.api.dtos.CreateProfessorDto;
import com.switchfully.professorwebapp.api.dtos.UpdateProfessorDto;
import com.switchfully.professorwebapp.domain.Professor;
import com.switchfully.professorwebapp.api.dtos.ProfessorDto;
import com.switchfully.professorwebapp.domain.ProfessorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

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
//    Furthermore, think about todo edge-cases, e.g.:

    private ProfessorRepository professorRepository;
    private ProfessorMapper professorMapper;

    public ProfessorController(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
        this.professorMapper = new ProfessorMapper();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ProfessorDto createProfessor(@RequestBody CreateProfessorDto createProfessorDto) {
        Professor professor = professorMapper.mapToProfessor(createProfessorDto);
        Professor savedProf = professorRepository.save(professor);
        return professorMapper.mapToDto(savedProf);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE, path = "{id}")
    public ProfessorDto updateProfessor(@RequestBody UpdateProfessorDto updateProfessorDto, @PathVariable String id) {
        Professor professor = professorRepository.getById(id);
        professor.setFirstName(updateProfessorDto.getFirstName());
        professor.setLastName(updateProfessorDto.getLastName());
        return professorMapper.mapToDto(professor);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<ProfessorDto> getAllProfessors() {
        return professorRepository.getAll().stream().map(prof -> professorMapper.mapToDto(prof)).collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = APPLICATION_JSON_VALUE, path = "{id}")
    public ProfessorDto getAllProfessors(@PathVariable String id) {
        return professorMapper.mapToDto(professorRepository.getById(id));
    }

}
