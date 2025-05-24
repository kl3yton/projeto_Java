package model;

public class Tarefa {
    private int id;
    private String titulo;
    private String descricao;
    private String status;  // Por exemplo: "Pendente", "Em andamento", "Concluída"
    private Categoria categoria;  // Associação com Categoria
    private Colaborador colaborador;  // Quem está responsável pela tarefa

    // Construtor
    public Tarefa(int id, String titulo, String descricao, String status, Categoria categoria, Colaborador colaborador) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.categoria = categoria;
        this.colaborador = colaborador;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
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
}
