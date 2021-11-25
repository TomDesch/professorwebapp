package com.switchfully.professorwebapp.domain.professor;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

// dummy db

@Component
public class ProfessorRepository {
    private final ConcurrentHashMap<String, Professor> professorsById;

    public ProfessorRepository() {
        professorsById = new ConcurrentHashMap<>();
    }

    public Professor save(Professor professor) {
        professorsById.put(professor.getId(), professor);
        return professor;
    }

    public Professor getById(String id) throws IllegalArgumentException {
        var foundProfessor = professorsById.get(id);
        if (foundProfessor == null) {
            throw new IllegalArgumentException("No professor could be found for id " + id);
        }
        return foundProfessor;
    }

    public void deleteProfessor(String id) throws IllegalArgumentException {
        var foundProfessor = professorsById.get(id);
        if (foundProfessor == null) {
            throw new IllegalArgumentException("No professor could be found for id " + id);
        }
        professorsById.remove(id);
    }

    public Collection<Professor> getAll() {return professorsById.values();}
}
