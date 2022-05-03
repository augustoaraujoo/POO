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

    // sets
    public void setCargo(String cargo) {this.cargo = cargo;}

    public void setMatricula(int matricula) {this.matricula = matricula;}

    public void setNome(String nome) {this.nome = nome;}

    public void setSalario(double salario) {this.salario = salario;}
    
    
    //gets
    public int getMatricula() { return this.matricula; }

    public String getNome() { return this.nome; }

    public String getCargo() { return this.cargo; }

    public double getSalario() { return this.salario; }

    
    
    
    
    
}
