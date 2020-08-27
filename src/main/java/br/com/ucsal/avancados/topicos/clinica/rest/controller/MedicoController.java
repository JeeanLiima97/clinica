package br.com.ucsal.avancados.topicos.clinica.rest.controller;

import br.com.ucsal.avancados.topicos.clinica.Service.MedicoService;
import br.com.ucsal.avancados.topicos.clinica.domain.entity.Medico;
import br.com.ucsal.avancados.topicos.clinica.domain.repository.MedicoRepository;
import br.com.ucsal.avancados.topicos.clinica.rest.DTO.MedicoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/medicos")
public class MedicoController {

    @Autowired
    MedicoRepository medicoRepository;
    @Autowired
    MedicoService medicoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Medico save(@RequestBody MedicoDTO medicoDTO) {
        return medicoService.salvar(medicoDTO);

    }
}
