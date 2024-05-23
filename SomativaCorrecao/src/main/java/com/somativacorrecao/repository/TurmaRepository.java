package com.somativacorrecao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.somativacorrecao.entities.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
}
