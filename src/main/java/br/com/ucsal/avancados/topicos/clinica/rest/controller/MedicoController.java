package br.com.ucsal.avancados.topicos.clinica.rest.controller;

import br.com.ucsal.avancados.topicos.clinica.domain.entity.Medico;
import br.com.ucsal.avancados.topicos.clinica.domain.repository.MedicoRepository;

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


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Medico save(@RequestBody Medico medico) {
         medicoRepository.save(medico);
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
    public void update(@PathVariable Integer id, @RequestBody Medico medico){
        medicoRepository.findById(id)
                .map(medico1 -> {
                   medico.setId(medico1.getId());
                   medicoRepository.save(medico);
                   return medico;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Empresa não encontrada"));
    }


    @GetMapping
    public List<Medico> findAll() {
        return medicoRepository.findAll();
    }
}
