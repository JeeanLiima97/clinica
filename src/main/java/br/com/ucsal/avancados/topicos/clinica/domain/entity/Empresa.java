package br.com.ucsal.avancados.topicos.clinica.domain.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    private String cnpj;

    @JsonIgnore
    @OneToMany(mappedBy = "empresa")
    private List<Funcionario> funcionarios = new ArrayList<>();

//    @ManyToOne
//    @JoinColumn(name = "clinica_id")
//    private Clinica clinica;


}
