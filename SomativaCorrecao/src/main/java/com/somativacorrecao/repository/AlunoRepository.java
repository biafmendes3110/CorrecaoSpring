package com.somativacorrecao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.somativacorrecao.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {  //ARRUMAR O NOME DA INTERFACE 
	//Query Methods
	List<Aluno> findByCidade(String cidade);
	List<Aluno> findByRa(String ra); //ADICIONAR O LIST 

}