package com.somativacorrecao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.somativacorrecao.entities.Aluno;
import com.somativacorrecao.repository.AlunoRepository;

@Service
public class AlunoService {
    private final AlunoRepository alunoRepository; //ARRUMAR O NOME DOS REPOSITORY
    
    @Autowired
    public AlunoService(AlunoRepository alunoRepository) { //ARRUMAR O NOME DA REPOSITORY
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> getAllAluno() { //RETIRAR O S DO GETALLALUNO
        return alunoRepository.findAll();
    }

    public Aluno getAlunoById(Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        return aluno.orElse(null);
    }
    //Query Method 
    public List<Aluno> buscarPorCidade(String cidade) {
        return alunoRepository.findByCidade(cidade); 
      }
    //Query Method 
    public List<Aluno> buscaPorRa(String ra) {
        return alunoRepository.findByRa(ra); //ARRUMAR OS QUERY METHODS
      }
  
    public Aluno salvarAluno(Aluno aluno) {
        return alunoRepository.save(aluno); //O COMANDO DO JPA É SAVE
    }

    public Aluno updateAluno(Long id, Aluno updatedAluno) {
        Optional<Aluno> existingAluno = alunoRepository.findById(id);
        if (existingAluno.isPresent()) { //RETIRAR O "E" DO PRESENT
            updatedAluno.setId(id);
            return alunoRepository.save(updatedAluno);
        }
        return null;
    }

    public boolean deleteAluno(Long id) {
        Optional<Aluno> existingAluno = alunoRepository.findById(id);
        if (existingAluno.isPresent()) { //RETIRAR O "E" DO PRESENT
            alunoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
