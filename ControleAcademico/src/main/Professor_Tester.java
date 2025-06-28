package main;

import model.Professor;

public class Professor_Tester {
    public static void main(String[] args) throws Exception {
       Professor prof1 = new Professor(
        "Paulo",
        "Rua 1",
        25,
        111,
        "111.222.333-44",
        "Instrutor"
       );
        // System.out.println(prof1);

       prof1.setNome("Paulo Oliveira");
       prof1.setEndereco("Rua 1, nº 20");

       prof1.visualizar();
    }
}
