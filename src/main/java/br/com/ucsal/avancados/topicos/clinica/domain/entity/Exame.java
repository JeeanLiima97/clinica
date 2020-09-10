package br.com.ucsal.avancados.topicos.clinica.domain.entity;

import br.com.ucsal.avancados.topicos.clinica.domain.entity.Enum.RiscoOcupacional;
import br.com.ucsal.avancados.topicos.clinica.domain.entity.Enum.TipoExame;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    @Enumerated(EnumType.STRING)
    private TipoExame tipoExame;

    @Enumerated(EnumType.STRING)
    private RiscoOcupacional riscoOcupacional;

    private String observacao;
}
