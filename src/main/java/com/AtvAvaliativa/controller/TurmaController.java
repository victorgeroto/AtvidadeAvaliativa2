package com.AtvAvaliativa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AtvAvaliativa.entity.Turma;
import com.AtvAvaliativa.service.TurmaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/turma")
public class TurmaController {
	private final TurmaService turmaService;

	@Autowired
	public TurmaController(TurmaService turmaService) {
		this.turmaService = turmaService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Turma> getalunoById(@PathVariable Long id) {
		Turma turma = turmaService.getTurmaById(id);
		if (turma != null) {
			return ResponseEntity.ok(turma);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Turma>> getAllTurma() {
		List<Turma> turma = turmaService.getAllTurma();
		return ResponseEntity.ok(turma);
	}

	@PostMapping("/")
	public ResponseEntity<Turma> criarTurma(@RequestBody @Valid Turma turma) {
		Turma criarTurma = turmaService.salvarTurma(turma);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarTurma);
	}


	@PutMapping("/{id}")
	public ResponseEntity<Turma> updateTurma(@PathVariable Long id, @RequestBody @Valid Turma turma) {
		Turma updatedTurma = turmaService.updateTurma(id, turma);
		if (updatedTurma != null) {
			return ResponseEntity.ok(updatedTurma);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTurma(@PathVariable Long id) {
		boolean deleted = turmaService.deleteTurma(id);
		if (deleted) {
			return ResponseEntity.ok().body("a Turma foi excluída com sucesso.");
		} else {
			return ResponseEntity.notFound().build();
		}
	}


}


