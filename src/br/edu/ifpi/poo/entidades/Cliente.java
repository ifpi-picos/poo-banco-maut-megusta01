package br.edu.ifpi.poo.entidades;
import java.time.LocalDate;

public class Cliente {
    private String nome;
    private final String cpf;
    private LocalDate dataNasc;
    private Endereco endereco;
    private Conta conta;

    public Cliente(String nome, String cpf, LocalDate dataNasc, Endereco endereco){
        this.nome = nome;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.endereco = endereco;
    }

    public Conta getConta(){
        return conta;
    }

    public void setConta(Conta conta){
        this.conta = conta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Cliente(){
        this.nome = "";
        this.cpf = "";
        this.dataNasc = null;
        this.endereco = null;
    }
}