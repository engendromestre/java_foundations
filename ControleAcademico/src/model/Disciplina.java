package model;

import java.util.Random;

public class Disciplina {
    private int id;
    private String nome;
    private int cargaHoraria; //todo mudar tipo para horas
    private String categoria;

    public Disciplina(String nome, int cargaHoraria, String categoria) {
        this.id = this.gerarId();
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.categoria = categoria;
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

    public int gerarId() {
        Random rand = new Random();
        int id = rand.nextInt(9999) + 1; // 1 até 9999
        return id;
    }

    public int getId() {
        return id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void visualizar() {
        System.out.println(
                "Identificação: " + id + "\n" +
                        "Disciplina: " + nome + "\n" +
                        "Carga Horária: " + cargaHoraria + "\n" +
                        "Categoria: " + categoria);
    }


}
