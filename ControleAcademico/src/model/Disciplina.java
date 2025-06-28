package model;

public class Disciplina {
    private String nome;
    private int cargaHoraria;
    private int id;

    public Disciplina(String nome, int cargaHoraria, int id) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void visualizar() {
        System.out.println(
                "Identificação: " + id + "\n" +
                        "Disciplina: " + nome + "\n" +
                        "Carga Horária: " + cargaHoraria);
    }
}
