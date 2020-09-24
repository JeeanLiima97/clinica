package br.com.ucsal.avancados.topicos.clinica.rest.DTO;

import br.com.ucsal.avancados.topicos.clinica.domain.entity.Empresa;
import br.com.ucsal.avancados.topicos.clinica.domain.entity.Enum.RiscoOcupacional;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExameEmpresaDTO {
    private RiscoOcupacional riscoOcupacional;
    private Long qntd;
    private Empresa empresa;



}
