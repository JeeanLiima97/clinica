package br.com.ucsal.avancados.topicos.clinica.domain.repository;

import br.com.ucsal.avancados.topicos.clinica.domain.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {
}
