package br.com.ucsal.avancados.topicos.clinica.domain.repository;

import br.com.ucsal.avancados.topicos.clinica.domain.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {


}
