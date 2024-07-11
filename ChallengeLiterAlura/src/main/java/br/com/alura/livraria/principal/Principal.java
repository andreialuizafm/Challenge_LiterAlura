package br.com.alura.livraria.principal;


import br.com.alura.livraria.model.Autor;
import br.com.alura.livraria.model.Livro;
import br.com.alura.livraria.repository.AutoresRepository;
import br.com.alura.livraria.service.ConsultaChatGPT;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private final AutoresRepository repositorio;
    private Scanner leitura = new Scanner(System.in);

    public Principal(AutoresRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void exibeMenu() {
        var opcao = -1;

        while (opcao != 9) {
            var menu = """
                                       
                                        
                    1- Buscar livro por título
                    2- Listar livros
                    3- Listar autores
                    4- Listar autores vivos no ano
                                    
                    9 - Sair
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    pesquisarDadosDoLivro();
                    break;
                case 2:
                    listarLivros();
                    break;
                case 3:
                    listarAutores();
                    break;
                case 4:
                    buscarAutorPorAno();
                    break;
                case 9:
                    System.out.println("Encerrando a aplicação!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void pesquisarDadosDoLivro() {
        System.out.println("Pesquisar dados sobre qual livro? ");
        var nome = leitura.nextLine();
        var resposta = ConsultaChatGPT.obterInformacao(nome);
        System.out.println(resposta.trim());
    }

    private void listarLivros() {
        List<Autor> autores = repositorio.findAll();
        autores.forEach(a -> a.getLivros().forEach(System.out::println));
    }

    private void listarAutores() {
        List<Autor> autores = repositorio.findAll();
        autores.forEach(a -> a.getLivros().forEach(System.out::println));
    }

    private void buscarAutorPorAno() {
        System.out.println("Buscar autores vivos por ano:");
        var ano = leitura.nextLine();
        List<Autor> autores = repositorio.buscarAutorPorAno(ano);
        autores.forEach(System.out::println);
    }
}




