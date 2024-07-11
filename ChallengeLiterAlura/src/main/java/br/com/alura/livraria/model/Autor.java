package br.com.alura.livraria.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nome;

    private LocalDate AnoNascimento;
    private LocalDate AnoFalecimento;
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Livro> livros = new ArrayList<>();

    public Autor() {
    }

    public Autor(Long id, String nome, LocalDate anoNascimento, LocalDate anoFalecimento, List<Livro> livros) {
        this.id = id;
        this.nome = nome;
        AnoNascimento = anoNascimento;
        AnoFalecimento = anoFalecimento;
        this.livros = livros;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getAnoNascimento() {
        return AnoNascimento;
    }

    public void setAnoNascimento(LocalDate anoNascimento) {
        AnoNascimento = anoNascimento;
    }

    public LocalDate getAnoFalecimento() {
        return AnoFalecimento;
    }

    public void setAnoFalecimento(LocalDate anoFalecimento) {
        AnoFalecimento = anoFalecimento;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", AnoNascimento=" + AnoNascimento +
                ", AnoFalecimento=" + AnoFalecimento +
                ", livros=" + livros +
                '}';

    }
}