package br.com.ucsal.avancados.topicos.clinica.Service.Impl;

import br.com.ucsal.avancados.topicos.clinica.Exception.RegraNegocioException;
import br.com.ucsal.avancados.topicos.clinica.Service.ExameService;
import br.com.ucsal.avancados.topicos.clinica.domain.entity.Enum.RiscoOcupacional;
import br.com.ucsal.avancados.topicos.clinica.domain.entity.Enum.TipoExame;
import br.com.ucsal.avancados.topicos.clinica.domain.entity.Exame;
import br.com.ucsal.avancados.topicos.clinica.domain.entity.Funcionario;
import br.com.ucsal.avancados.topicos.clinica.domain.entity.Medico;
import br.com.ucsal.avancados.topicos.clinica.domain.repository.ExameRepository;
import br.com.ucsal.avancados.topicos.clinica.domain.repository.FuncionarioRepository;
import br.com.ucsal.avancados.topicos.clinica.domain.repository.MedicoRepository;
import br.com.ucsal.avancados.topicos.clinica.rest.DTO.ExameDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExameServiceImpl implements ExameService {

    @Autowired
    ExameRepository exameRepository;
    @Autowired
    FuncionarioRepository funcionarioRepository;
    @Autowired
    MedicoRepository medicoRepository;

    @Override
    public Exame salvar(ExameDTO exameDTO) {
        Integer idFuncionario = exameDTO.getFuncionario();
        Integer idMedico = exameDTO.getMedico();
        Funcionario funcionario = funcionarioRepository.findById(idFuncionario)
                .orElseThrow(() -> new RegraNegocioException("Codigo de funcionario invalido"));
        Medico medico = medicoRepository.findById(idMedico)
                .orElseThrow(() -> new RegraNegocioException("Codigo de medico invalido"));
    Exame exame = new Exame();
    exame.setFuncionario(funcionario);
    exame.setMedico(medico);
    exame.setObservacao(exameDTO.getObservacao());
    exame.setTipoExame(TipoExame.valueOf(exameDTO.getTipoExame()));
    exame.setRiscoOcupacional(RiscoOcupacional.valueOf(exameDTO.getRiscoOcupacional()));
    exameRepository.save(exame);
    return exame;
    }

    @Override
    public Exame editar(ExameDTO exameDTO) {
        return null;
    }
}
