package br.com.ucsal.avancados.topicos.clinica.rest.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaDTO {

    private Integer id;
    private Integer clinica;
    private String cnpj;
    private String nome;

}
