package br.edu.ifpi.poo.entidades;
import java.time.LocalDate;

public class Transacao {
    private String descricao;
    private double valor;
    private LocalDate data;

    public Transacao(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
        this.data = LocalDate.now();
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public LocalDate getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Descrição: " + descricao + "\nValor: " + valor + "\nData: " + data;
    }
}