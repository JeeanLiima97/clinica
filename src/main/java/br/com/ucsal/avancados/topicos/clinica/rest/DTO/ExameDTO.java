package br.com.ucsal.avancados.topicos.clinica.rest.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExameDTO {

    private Integer id;
    private Integer medico;
    private Integer funcionario;
    private String tipoExame;

}
