package br.com.paulo.forumAlura.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.paulo.forumAlura.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

	Curso findByNome(String nomeCruso);

}
