package br.com.ucsal.avancados.topicos.clinica.Service.Impl;

import br.com.ucsal.avancados.topicos.clinica.Exception.RegraNegocioException;
import br.com.ucsal.avancados.topicos.clinica.Service.EmpresaService;
import br.com.ucsal.avancados.topicos.clinica.domain.entity.Clinica;
import br.com.ucsal.avancados.topicos.clinica.domain.entity.Empresa;
import br.com.ucsal.avancados.topicos.clinica.domain.repository.ClinicaRepository;
import br.com.ucsal.avancados.topicos.clinica.domain.repository.EmpresaRepository;
import br.com.ucsal.avancados.topicos.clinica.rest.controller.DTO.EmpresaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaServiceImpl implements EmpresaService {
    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private ClinicaRepository clinicaRepository;

    @Override
    public Empresa salvar(EmpresaDTO empresaDTO) {
        Integer idClinica = empresaDTO.getClinica();
        Clinica clinica = clinicaRepository.findById(idClinica)
                .orElseThrow(()-> new RegraNegocioException("Codigo de clinica invalido"));

        Empresa empresa = new Empresa();
        empresa.setCnpj(empresaDTO.getCnpj());
        empresa.setNome(empresaDTO.getNome());
        empresa.setClinica(clinica);

        empresaRepository.save(empresa);
        return empresa;

    }
}
