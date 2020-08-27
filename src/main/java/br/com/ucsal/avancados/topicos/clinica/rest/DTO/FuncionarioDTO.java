package br.com.ucsal.avancados.topicos.clinica.rest.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioDTO {

    private Integer id;
    private Integer matricula;
    private String nome;
    private Integer empresa;

}
