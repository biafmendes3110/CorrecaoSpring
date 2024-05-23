package com.somativacorrecao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.somativacorrecao.entities.Turma;
import com.somativacorrecao.repository.TurmaRepository;

@Service
public class TurmaService {
    private final TurmaRepository turmaRepository; //ALTERAR O NOME DO REPOSITORY
    
    @Autowired
    public TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    public List<Turma> getAllTurmas() {
        return turmaRepository.findAll();
    }

    public Turma getTurmaById(Long id) {
        Optional<Turma> turma = turmaRepository.findById(id);
        return turma.orElse(null);
    }

    public Turma salvarTurma(Turma turma) {
        return turmaRepository.save(turma); //ALTERAR O COMANDO DO JPA PARA SAVE
    }

    public Turma updateTurma(Long id, Turma updatedTurma) {
        Optional<Turma> existingTurma = turmaRepository.findById(id);
        if (existingTurma.isPresent()) { //RETIRAR O "E" DO PRESENT
            updatedTurma.setId(id);
            return turmaRepository.save(updatedTurma);
        }
        return null;
    }

    public boolean deleteTurma(Long id) {
        Optional<Turma> existingTurma = turmaRepository.findById(id);
        if (existingTurma.isPresent()) { //RETIRAR O "E" DO PRESENT
            turmaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

