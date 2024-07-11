package br.com.alura.livraria.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosAutor( @JsonAlias("authors") String Nome,
                         @JsonAlias("birth_year") LocalDate AnoNascimento,
                         @JsonAlias("death_year") LocalDate AnoFalecimento
                        ){

}
