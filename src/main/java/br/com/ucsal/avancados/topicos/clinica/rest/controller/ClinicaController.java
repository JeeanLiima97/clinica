package br.com.ucsal.avancados.topicos.clinica.rest.controller;


import br.com.ucsal.avancados.topicos.clinica.domain.entity.Clinica;
import br.com.ucsal.avancados.topicos.clinica.domain.repository.ClinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/clinica")
public class ClinicaController {

    @Autowired
    ClinicaRepository clinicaRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Clinica save(@RequestBody Clinica clinica){
        return clinicaRepository.save(clinica);
    }

    @GetMapping
    public Clinica getClinicaById(@PathVariable Integer id){
        return clinicaRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Clinica não encontrada"));
    }



    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){

        clinicaRepository.findById(id)
                .map(clinica -> {
                    clinicaRepository.delete(clinica);
                    return clinica;
                }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Clinica não encontrada"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody Clinica clinica){
        clinicaRepository.findById(id)
                .map(clinicaExist -> {
                    clinica.setId(clinicaExist.getId());
                    clinicaRepository.save(clinica);
                    return clinicaExist;
                }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Clinica não encontrada"));
    }

    @GetMapping
    public List<Clinica> find (Clinica filtro){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(filtro, matcher);
        return clinicaRepository.findAll(example);
    }

}
