package com.example.trabalhotalles.Classes;

import java.util.ArrayList;
import java.util.List;

public class Estabelecimento {
    private String nome;
    private String endereco;
    private String horarioFuncionamento;
    private String categoria; //  Restaurante, Mercado, Farmácia
    private List<Item> itens;

    public Estabelecimento(String nome, String endereco, String horarioFuncionamento, String categoria) {
        this.nome = nome;
        this.endereco = endereco;
        this.horarioFuncionamento = horarioFuncionamento;
        this.categoria = categoria;
        this.itens= new ArrayList<>();
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

    public String getHorarioFuncionamento() {
        return horarioFuncionamento;
    }

    public void setHorarioFuncionamento(String horarioFuncionamento) {
        this.horarioFuncionamento = horarioFuncionamento;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public void removerItem(Item item) {
        itens.remove(item);
    }

    public List<Item> getItens() {
        return itens;
    }


}

