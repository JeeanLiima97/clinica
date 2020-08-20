package br.com.ucsal.avancados.topicos.clinica.domain.repository;

import br.com.ucsal.avancados.topicos.clinica.domain.entity.Exame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExameRepository extends JpaRepository<Exame, Integer> {
}
