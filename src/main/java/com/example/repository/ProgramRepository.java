package com.example.repository;


import com.example.domain.Program;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ProgramRepository extends CrudRepository<Program, Long> {
    public Program findByName(String name);
}
