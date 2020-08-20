package br.com.ucsal.avancados.topicos.clinica.domain.repository;

import br.com.ucsal.avancados.topicos.clinica.domain.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {



}
