//package br.com.ucsal.avancados.topicos.clinica.Service.Impl;
//
//import br.com.ucsal.avancados.topicos.clinica.Exception.RegraNegocioException;
//import br.com.ucsal.avancados.topicos.clinica.Service.MedicoService;
//
//import br.com.ucsal.avancados.topicos.clinica.domain.entity.Medico;
//import br.com.ucsal.avancados.topicos.clinica.domain.repository.MedicoRepository;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MedicoServiceImpl implements MedicoService {
//
//    @Autowired
//    private MedicoRepository medicoRepository;
//
//    @Autowired
//    private ClinicaRepository clinicaRepository;
//
//    public Medico salvar(MedicoDTO medicoDTO) {
//        Integer idClinica = medicoDTO.getClinica();
//        Clinica clinica = clinicaRepository.findById(idClinica)
//                .orElseThrow(() -> new RegraNegocioException("Codigo de clinica invalido"));
//        Medico medico = new Medico();
//        medico.setCrm(medicoDTO.getCrm());
//        medico.setNome(medicoDTO.getNome());
//        medico.setClinica(clinica);
//        medicoRepository.save(medico);
//
//        return medico;
//    }
//
//    @Override
//    public Medico editar(MedicoDTO medicoDTO) {
//        Integer idClinica = medicoDTO.getClinica();
//        Clinica clinica = clinicaRepository.findById(idClinica)
//                .orElseThrow(()-> new RegraNegocioException("Codigo de clinica invalido"));
//
//        Medico medico = new Medico();
//        medico.setCrm(medicoDTO.getCrm());
//        medico.setNome(medicoDTO.getNome());
//        medico.setClinica(clinica);
//        medico.setId(medicoDTO.getId());
//        medicoRepository.save(medico);
//        return medico;
//
//    }
//
//
//}
