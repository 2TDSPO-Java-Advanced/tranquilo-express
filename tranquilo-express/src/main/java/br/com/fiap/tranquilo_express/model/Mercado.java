package br.com.fiap.tranquilo_express.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TDS_TB_mercado")
public class Mercado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String tipo;
    private String setor;
    private String tamanho;
    private Double preco;

    // Construtor vazio
    public Mercado() {
    }

    // Construtor cheio
    public Mercado(Long id, String nome, String tipo, String setor, String tamanho, Double preco) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.setor = setor;
        this.tamanho = tamanho;
        this.preco = preco;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getSetor() { return setor; }
    public void setSetor(String setor) { this.setor = setor; }

    public String getTamanho() { return tamanho; }
    public void setTamanho(String tamanho) { this.tamanho = tamanho; }

    public Double getPreco() { return preco; }
    public void setPreco(Double preco) { this.preco = preco; }
}