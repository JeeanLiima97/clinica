package br.com.ucsal.avancados.topicos.clinica.Service.Impl;

import br.com.ucsal.avancados.topicos.clinica.Exception.RegraNegocioException;
import br.com.ucsal.avancados.topicos.clinica.Service.FuncionarioService;
import br.com.ucsal.avancados.topicos.clinica.domain.entity.Empresa;
import br.com.ucsal.avancados.topicos.clinica.domain.entity.Funcionario;
import br.com.ucsal.avancados.topicos.clinica.domain.repository.EmpresaRepository;
import br.com.ucsal.avancados.topicos.clinica.domain.repository.FuncionarioRepository;
import br.com.ucsal.avancados.topicos.clinica.rest.DTO.FuncionarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    FuncionarioRepository funcionarioRepository;
    @Autowired
    EmpresaRepository empresaRepository;


    @Override
    public Funcionario salvar(FuncionarioDTO funcionarioDTO) {
        Integer idEmpresa = funcionarioDTO.getEmpresa();
        Empresa empresa = empresaRepository.findById(idEmpresa)
                .orElseThrow(() -> new RegraNegocioException("Codigo de empresa invalido"));

        Funcionario funcionario = new Funcionario();
        funcionario.setMatricula(funcionarioDTO.getMatricula());
        funcionario.setNome(funcionarioDTO.getNome());
        funcionario.setEmpresa(empresa);
        funcionarioRepository.save(funcionario);
        return funcionario;
    }

    @Override
    public Funcionario editar(FuncionarioDTO funcionarioDTO) {
        Integer idEmpresa = funcionarioDTO.getEmpresa();
        Empresa empresa = empresaRepository.findById(idEmpresa)
                .orElseThrow(() -> new RegraNegocioException("Codigo de empresa invalido"));

        Funcionario funcionario = new Funcionario();
        funcionario.setMatricula(funcionarioDTO.getMatricula());
        funcionario.setNome(funcionarioDTO.getNome());
        funcionario.setEmpresa(empresa);
        funcionario.setId(funcionarioDTO.getId());
        funcionarioRepository.save(funcionario);
        return funcionario;
    }
}
