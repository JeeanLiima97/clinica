package br.com.ucsal.avancados.topicos.clinica.Service;

import br.com.ucsal.avancados.topicos.clinica.domain.entity.Funcionario;
import br.com.ucsal.avancados.topicos.clinica.rest.DTO.FuncionarioDTO;

public interface FuncionarioService {

    Funcionario salvar(FuncionarioDTO funcionarioDTO);

    Funcionario editar(FuncionarioDTO funcionarioDTO);

}
