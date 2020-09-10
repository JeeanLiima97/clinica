package br.com.ucsal.avancados.topicos.clinica.domain.repository;

import br.com.ucsal.avancados.topicos.clinica.domain.entity.Enum.RiscoOcupacional;
import br.com.ucsal.avancados.topicos.clinica.domain.entity.Exame;
import br.com.ucsal.avancados.topicos.clinica.rest.DTO.ExameResultDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExameRepository extends JpaRepository<Exame, Integer> {
    //select risco_ocupacional, COUNT (risco_ocupacional) AS qtd from exame group by risco_ocupacional;
    long countByRiscoOcupacional(RiscoOcupacional riscoOcupacional);

//    @Query("select " +
//            "new riscoOcupacional, COUNT (riscoOcupacional) AS qtd from Exame group by riscoOcupacional")
//

    @Query("select " +
            " new br.com.ucsal.avancados.topicos.clinica.rest.DTO.ExameResultDTO(e.riscoOcupacional, COUNT(e)) " +
            "FROM " +
            "Exame e" +
            " GROUP BY " +
            "e.riscoOcupacional"
    )
    List<ExameResultDTO> findRiscoOperacional();
}
