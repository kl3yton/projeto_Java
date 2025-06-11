package src.model;

import java.time.LocalDate;

public class Tarefa extends Entidade {
    private String titulo;
    private String descricao;
    private String status;
    private LocalDate dataCriacao;
    private LocalDate dataConclusao;
    private Categoria categoria;
    private Colaborador colaborador;

    public Tarefa() {}

    public Tarefa(String titulo, String descricao, String status, LocalDate dataCriacao, LocalDate dataConclusao, Categoria categoria, Colaborador colaborador) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.dataCriacao = dataCriacao;
        this.dataConclusao = dataConclusao;
        this.categoria = categoria;
        this.colaborador = colaborador;
    }

    // Getters e Setters...

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDate dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    @Override
    public String toString() {
        return "[" + status + "] " + titulo + " (" + categoria + ")";
    }
}
