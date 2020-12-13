package com.whatevertech.petfinder.request;


import java.time.LocalDate;
import java.util.Objects;

public class AnimalRequest {

    private String nome;
    private String descricao;
    private LocalDate dataRegistro;
    private String urlImagem;

    public AnimalRequest(String nome, String descricao, LocalDate dataRegistro, String urlImagem) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataRegistro = dataRegistro;
        this.urlImagem = urlImagem;
    }

    public AnimalRequest() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalRequest that = (AnimalRequest) o;
        return Objects.equals(nome, that.nome) && Objects.equals(descricao, that.descricao) && Objects.equals(dataRegistro, that.dataRegistro) && Objects.equals(urlImagem, that.urlImagem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao, dataRegistro, urlImagem);
    }
}
