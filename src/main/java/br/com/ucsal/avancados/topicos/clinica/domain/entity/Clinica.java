package br.com.ucsal.avancados.topicos.clinica.domain.entity;


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
public class Clinica {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;

    @OneToMany(mappedBy = "clinica")
    private List<Empresa> empresas = new ArrayList<>();

    @OneToMany(mappedBy = "clinica")
    private List<Medico> medicos = new ArrayList<>();


}
