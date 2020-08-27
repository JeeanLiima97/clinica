package br.com.ucsal.avancados.topicos.clinica.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String crm;

    @ManyToOne
    @JoinColumn(name = "clinica_id")
    private Clinica clinica;


    @OneToMany(mappedBy = "medico")
    private List<Exame> exames;

}
