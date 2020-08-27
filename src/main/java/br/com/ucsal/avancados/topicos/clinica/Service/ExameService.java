package br.com.ucsal.avancados.topicos.clinica.Service;

import br.com.ucsal.avancados.topicos.clinica.domain.entity.Exame;
import br.com.ucsal.avancados.topicos.clinica.rest.DTO.ExameDTO;

public interface ExameService {

    Exame salvar(ExameDTO exameDTO);

    Exame editar(ExameDTO exameDTO);
}
