package br.com.ucsal.avancados.topicos.clinica.rest.controller;


import br.com.ucsal.avancados.topicos.clinica.domain.entity.Empresa;
import br.com.ucsal.avancados.topicos.clinica.domain.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/empresas")
@CrossOrigin("http://localhost:4200")

public class EmpresaController {

    @Autowired
    EmpresaRepository empresaRepository;
//    @Autowired
//    EmpresaService empresaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Empresa save(@RequestBody Empresa empresa) {
        empresaRepository.save(empresa);
        return empresa;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        empresaRepository.findById(id)
                .map(empresa -> {
                    empresaRepository.delete(empresa);
                    return empresa;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Empresa não encontrada"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody Empresa empresa){
        empresaRepository.findById(id)
                .map(empresaNova -> {
                    empresa.setId(empresaNova.getId());
                    empresaRepository.save(empresa);
                    return empresa;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Empresa não encontrada"));
    }


    @GetMapping
    public List<Empresa> findAll(){
        return empresaRepository.findAll();
    }
}
