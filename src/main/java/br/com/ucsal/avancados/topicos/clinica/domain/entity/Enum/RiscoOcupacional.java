package br.com.ucsal.avancados.topicos.clinica.domain.entity.Enum;

public enum  RiscoOcupacional {

    FISICO(1, "Admissional"),
    QUIMICO(2, "Periodico"),
    BIOLOGICO(3, "Retorno ao Trabalho"),
    ERGONOMICO(4, "Demissional"),
    ACIDENTAL(5, "Transferencia de função");


    private int cod;
    private String descricao;

    private RiscoOcupacional(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }
    public int getCod() {
        return cod;
    }
    public String getDescricao() {
        return descricao;
    }

    public static TipoExame toEnum(Integer cod) {
        if(cod == null) {
            return null;
        }
        for(TipoExame x: TipoExame.values()) {
            if(cod.equals(x.getCod())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id invalido" + cod);
    }
}
