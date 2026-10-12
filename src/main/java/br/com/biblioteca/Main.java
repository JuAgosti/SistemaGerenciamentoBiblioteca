package br.com.biblioteca;

import br.com.biblioteca.exception.LivroIndisponivelException;
import br.com.biblioteca.model.Emprestimo;
import br.com.biblioteca.model.Livro;
import br.com.biblioteca.model.Usuario;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Livro livro = new Livro(
                "O Pequeno Príncipe",
                "Antoine de Saint-Exupéry",
                "978-8595081512",
                2015,
                "Fantasia"
        );

        Usuario usuario1 = new Usuario(
                "Maria da Silva",
                "529.982.247-25",
                "maria@email.com",
                "(51) 99999-9999"
        );

        Usuario usuario2 = new Usuario(
                "João da Silva",
                "111.444.777-35",
                "joao@email.com",
                "(51) 98888-7777"
        );

        try {
            // Primeiro empréstimo: deve funcionar.
            Emprestimo emprestimo1 = new Emprestimo(
                    livro,
                    usuario1,
                    LocalDate.now()
            );

            System.out.println("Primeiro empréstimo realizado!");
            System.out.println("Livro: " + emprestimo1.getLivro().getTitulo());

            // Segundo empréstimo: o livro já está emprestado.
            System.out.println("\nTentando emprestar o mesmo livro novamente...");

            Emprestimo emprestimo2 = new Emprestimo(
                    livro,
                    usuario2,
                    LocalDate.now()
            );

            System.out.println("Segundo empréstimo realizado!");

        } catch (LivroIndisponivelException e) {
            System.out.println("\nERRO: " + e.getMessage());
        }
    }
}