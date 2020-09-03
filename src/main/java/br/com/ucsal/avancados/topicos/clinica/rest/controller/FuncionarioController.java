package br.com.ucsal.avancados.topicos.clinica.rest.controller;

import br.com.ucsal.avancados.topicos.clinica.Service.FuncionarioService;
import br.com.ucsal.avancados.topicos.clinica.domain.entity.Funcionario;
import br.com.ucsal.avancados.topicos.clinica.domain.repository.FuncionarioRepository;
import br.com.ucsal.avancados.topicos.clinica.rest.DTO.FuncionarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/funcionarios")
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;
    @Autowired
    FuncionarioRepository funcionarioRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Funcionario save(@RequestBody FuncionarioDTO funcionarioDTO){

        return funcionarioService.salvar(funcionarioDTO);

    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody FuncionarioDTO funcionarioDTO){
        funcionarioRepository.findById(id)
                .map(funcionario -> {
                    funcionarioDTO.setId(funcionario.getId());
                    funcionarioService.editar(funcionarioDTO);
                    return funcionarioDTO;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionario não encontrado"));
    }

    @GetMapping
    public List<Funcionario> findAll(){return funcionarioRepository.findAll();}


    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        funcionarioRepository.findById(id)
                .map(funcionario -> {
                    funcionarioRepository.delete(funcionario);
                    return funcionario;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionario não encontrado"));
    }

    @GetMapping("{id}")
    public Funcionario getFuncionarioById(@PathVariable Integer id){
        return funcionarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionario não encontrado"));
    }
}
