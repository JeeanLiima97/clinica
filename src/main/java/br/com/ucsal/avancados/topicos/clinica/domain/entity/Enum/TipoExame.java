package br.com.ucsal.avancados.topicos.clinica.domain.entity.Enum;

public enum TipoExame {
    ADMISSIONAL(1, "Admissional"),
    PERIODICO(2, "Periodico"),
    RETORNO(3, "Retorno ao Trabalho"),
    DEMISSIONAL(4, "Demissional"),
    TRANSFERENCIA(5, "Transferencia de função");


    private int cod;
    private String descricao;

    private TipoExame(int cod, String descricao) {
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
