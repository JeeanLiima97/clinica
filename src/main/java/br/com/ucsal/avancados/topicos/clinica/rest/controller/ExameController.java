package br.com.ucsal.avancados.topicos.clinica.rest.controller;

import br.com.ucsal.avancados.topicos.clinica.Service.ExameService;
import br.com.ucsal.avancados.topicos.clinica.domain.entity.Exame;
import br.com.ucsal.avancados.topicos.clinica.domain.repository.ExameRepository;
import br.com.ucsal.avancados.topicos.clinica.rest.DTO.ExameDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("api/exames")
public class ExameController {
    @Autowired
    ExameRepository exameRepository;
    @Autowired
    ExameService exameService;

    @PostMapping
    public Exame save(@RequestBody ExameDTO exameDTO) {
        return exameService.salvar(exameDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        exameRepository.findById(id)
                .map(exame -> {
                    exameRepository.delete(exame);
                    return exame;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Exame não encontrado"));

    }

    @GetMapping
    public List<Exame> findAll() {
        return exameRepository.findAll();
    }

}
