package com.switchfully.professorwebapp.api.dtos.professor;

import com.switchfully.professorwebapp.domain.professor.Professor;
import com.switchfully.professorwebapp.domain.professor.ProfessorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "professors")
public class ProfessorController {
//    Furthermore, think about todo edge-cases, e.g.:

    private final ProfessorRepository professorRepository;
    private final ProfessorMapper professorMapper;

    //todo make it so you can filter on study points
    // when no query parameter is defined ,all courses should be returned

    public ProfessorController(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
        this.professorMapper = new ProfessorMapper();
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(consumes = APPLICATION_JSON_VALUE, path = "{id}")
    public void deleteProfessor(@PathVariable String id) {
        professorRepository.deleteProfessor(id);
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
        return professorRepository.getAll().stream().map(professorMapper::mapToDto).collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = APPLICATION_JSON_VALUE, path = "{id}")
    public ProfessorDto getAllProfessors(@PathVariable String id) {
        return professorMapper.mapToDto(professorRepository.getById(id));
    }
}
