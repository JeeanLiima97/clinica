package br.com.ucsal.avancados.topicos.clinica.Service;

import br.com.ucsal.avancados.topicos.clinica.domain.entity.Medico;
import br.com.ucsal.avancados.topicos.clinica.rest.DTO.MedicoDTO;

public interface MedicoService {

    Medico salvar(MedicoDTO medicoDTO);
}
