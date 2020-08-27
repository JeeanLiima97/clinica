package br.com.ucsal.avancados.topicos.clinica.rest.controller;


import br.com.ucsal.avancados.topicos.clinica.Service.EmpresaService;
import br.com.ucsal.avancados.topicos.clinica.domain.entity.Empresa;
import br.com.ucsal.avancados.topicos.clinica.domain.repository.EmpresaRepository;
import br.com.ucsal.avancados.topicos.clinica.rest.controller.DTO.EmpresaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/empresa")
public class EmpresaController {

    @Autowired
    EmpresaRepository empresaRepository;
    @Autowired
    EmpresaService empresaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer save(@RequestBody EmpresaDTO empresaDTO){
        Empresa empresa = empresaService.salvar(empresaDTO);
        return empresa.getId();
    }

}
