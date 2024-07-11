package br.com.alura.livraria.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLivro(@JsonAlias("title") String Titulo,
                         @JsonAlias("languages") String Idioma,
                         @JsonAlias("download_count") String Downloads,
                         @JsonAlias("authors") String Nome) {

                         }
