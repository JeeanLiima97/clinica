package br.com.ucsal.avancados.topicos.clinica.rest.controller;


import br.com.ucsal.avancados.topicos.clinica.Service.EmpresaService;
import br.com.ucsal.avancados.topicos.clinica.domain.entity.Empresa;
import br.com.ucsal.avancados.topicos.clinica.domain.repository.EmpresaRepository;
import br.com.ucsal.avancados.topicos.clinica.rest.controller.DTO.EmpresaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/empresa")
public class EmpresaController {

    @Autowired
    EmpresaRepository empresaRepository;
    @Autowired
    EmpresaService empresaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Empresa save(@RequestBody EmpresaDTO empresaDTO) {
        Empresa empresa = empresaService.salvar(empresaDTO);
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
    public void update(@PathVariable Integer id, @RequestBody EmpresaDTO empresaDTO){
        empresaRepository.findById(id)
                .map(empresaNova -> {
                    empresaDTO.setId(empresaNova.getId());
                    empresaService.editar(empresaDTO);
                    return empresaDTO;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Empresa não encontrada"));
    }

}
