package model;

import java.util.Random;

public class Professor {
    private String nome;
    private String endereco;
    private int idade;
    private int matricula;
    private String cpf;
    private String atuacao;

    public Professor() {
    }

    public Professor(String nome, String endereco, int idade, String cpf, String atuacao) {
        this.nome = nome;
        this.endereco = endereco;
        this.idade = idade;
        this.matricula = this.gerarMatricula();
        this.cpf = cpf;
        this.atuacao = atuacao;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getAtuacao() {
        return atuacao;
    }

    public void setAtuacao(String atuacao) {
        this.atuacao = atuacao;
    }

    @Override
    public String toString() {
        return "Professor [nome=" + nome + ", endereco=" + endereco + ", idade=" + idade + ", matricula=" + matricula
                + ", cpf=" + cpf + ", atuacao=" + atuacao + "]";
    }

    public void visualizar() {
        System.out.println("Nº de Matrícula: " + matricula);
        System.out.println("Nome Completo: " + nome);
        System.out.println("Endereço: " + endereco);
        System.out.println("Idade: " + idade);
        System.out.println("CPF: " + cpf);
        System.out.println("Atuação: " + atuacao);
    }

}
