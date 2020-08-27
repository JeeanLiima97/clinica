package br.com.ucsal.avancados.topicos.clinica.Service;

import br.com.ucsal.avancados.topicos.clinica.domain.entity.Empresa;
import br.com.ucsal.avancados.topicos.clinica.rest.DTO.EmpresaDTO;

public interface EmpresaService {

    Empresa salvar(EmpresaDTO empresaDTO);
    Empresa editar(EmpresaDTO empresaDTO);
}
