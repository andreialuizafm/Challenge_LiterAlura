package br.com.alura.livraria.repository;

import br.com.alura.livraria.model.Autor;
import br.com.alura.livraria.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LivrosRepository extends JpaRepository<Livro, Long> {
    Optional<Livro> findByNomeContainingIgnoreCase(String nome);


    List<Livro> buscaAutor(String nome);

    List<Livro> buscarAutorPorAno(String ano);
}