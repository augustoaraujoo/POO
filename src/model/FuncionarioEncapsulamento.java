package model;

public class FuncionarioEncapsulamento {

    private int matricula;
    private String nome;
    private String cargo;
    private double salario;

    public void FuncionarioEncapsulamento(int matricula, String nome, String cargo, double salario) {
        this.matricula = matricula;
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    //gets
    public int getMatricula() { return this.matricula; }

    public String getNome() { return this.nome; }
    
    public String getCargo() { return this.cargo; }

    public double getSalario() { return this.salario; }

}
