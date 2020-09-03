//package br.com.ucsal.avancados.topicos.clinica.domain.entity;
//
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class Clinica {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//    private String nome;
//
//    @JsonIgnore
//    @OneToMany(mappedBy = "clinica")
//    private List<Empresa> empresas = new ArrayList<>();
//
//    @JsonIgnore
//    @OneToMany(mappedBy = "clinica")
//    private List<Medico> medicos = new ArrayList<>();
//
//
//}
