package model;

import java.util.Random;

public class Aluno {
    private String nome;
    private String endereco;
    private int idade;
    private int matricula;

    public Aluno() {
    }

    public Aluno(String nome, String endereco, int idade) {
        this.nome = nome;
        this.endereco = endereco;
        this.idade = idade;
        this.matricula = this.gerarMatricula();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getMatricula() {
        return matricula;
    }

    public int gerarMatricula() {
        Random rand = new Random();
        int matricula = rand.nextInt(9999) + 1;
        return matricula;
    }

    @Override
    public String toString() {
        return "Aluno [nome=" + nome + ", endereco=" + endereco + ", idade=" + idade + ", matricula=" + matricula + "]";
    }

    public void visualizar() {
        System.out.println("Nome: " + nome);
        System.out.println("Endereço: " + endereco);
        System.out.println("Idade: " + idade);
        System.out.println("Número da Matrícula: " + matricula);
    }
}
