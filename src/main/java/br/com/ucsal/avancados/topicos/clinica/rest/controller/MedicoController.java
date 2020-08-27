package br.com.ucsal.avancados.topicos.clinica.rest.controller;

import br.com.ucsal.avancados.topicos.clinica.Service.MedicoService;
import br.com.ucsal.avancados.topicos.clinica.domain.entity.Medico;
import br.com.ucsal.avancados.topicos.clinica.domain.repository.MedicoRepository;
import br.com.ucsal.avancados.topicos.clinica.rest.DTO.EmpresaDTO;
import br.com.ucsal.avancados.topicos.clinica.rest.DTO.MedicoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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
        Medico medico = medicoService.salvar(medicoDTO);
        return medico;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        medicoRepository.findById(id)
                .map(medico -> {
                    medicoRepository.delete(medico);
                    return medico;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Medico não encontrado"));
    }



    @GetMapping("{id}")
    public Medico getMedicoById(@PathVariable Integer id) {
        return medicoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Medico não encontrado"));

    }


    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody MedicoDTO medicoDTO){
        medicoRepository.findById(id)
                .map(medico1 -> {
                   medicoDTO.setId(medico1.getId());
                   medicoService.editar(medicoDTO);
                   return medicoDTO;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Empresa não encontrada"));
    }


    @GetMapping
    public List<Medico> findAll() {
        return medicoRepository.findAll();
    }
}