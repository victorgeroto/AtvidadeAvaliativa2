package com.AtvAvaliativa.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.AtvAvaliativa.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
	List<Aluno> findByCidade(String cidade);
	//List<Aluno> findByNome(String nome);
	List<Aluno> findByCidadeAndRenda(String cidade, Double renda);
	List<Aluno> findByRa(String ra);
	
	//Buscar Todos os Alunos com nome "XXX":
	@Query("SELECT a FROM Aluno a WHERE a.nome = :nome")
	List<Aluno> findByNome(@Param("nome") String nome);
	
	//Buscar nome completo 
		@Query("SELECT a FROM Aluno a WHERE a.nomeCompleto LIKE :nomeCompleto")
		List<Aluno> findByNomeLike(@Param("NomeCompleto") String nomeCompleto);
	//Buscar todos os alunos de uma determinada turma:
		@Query("SELECT a FROM Aluno a JOIN a.turma t WHERE t.id = :turmaId")
		List<Aluno> findByTurmaId(@Param("turmaId") Long turmaId);
}

