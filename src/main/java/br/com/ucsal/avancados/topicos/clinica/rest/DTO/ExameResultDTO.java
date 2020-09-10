package br.com.ucsal.avancados.topicos.clinica.rest.DTO;

import br.com.ucsal.avancados.topicos.clinica.domain.entity.Enum.RiscoOcupacional;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExameResultDTO {

    private RiscoOcupacional risco;
    private long qntd;

}
