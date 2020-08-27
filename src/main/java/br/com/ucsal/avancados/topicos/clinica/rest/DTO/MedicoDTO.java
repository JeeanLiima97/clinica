package br.com.ucsal.avancados.topicos.clinica.rest.DTO;

import br.com.ucsal.avancados.topicos.clinica.domain.entity.Clinica;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicoDTO {

    private Integer id;

    private String nome;

    private String crm;

    private Integer clinica;

}
