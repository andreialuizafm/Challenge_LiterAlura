package br.com.alura.livraria.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;

    private String idioma;
    private int downloads;
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Autor> autores = new ArrayList<>();

    public Livro() {
    }

    public Livro(Long id, String titulo, String idioma, int downloads, List<Autor> autores) {
        this.id = id;
        this.titulo = titulo;
        this.idioma = idioma;
        this.downloads = downloads;
        this.autores = autores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getDownloads() {
        return downloads;
    }

    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }
        @Override
        public String toString() {
            return "Livro{" +
                    "id=" + id +
                    ", titulo='" + titulo + '\'' +
                    ", idioma='" + idioma + '\'' +
                    ", downloads=" + downloads +
                    ", autores=" + autores +
                    '}';
        }
    }
