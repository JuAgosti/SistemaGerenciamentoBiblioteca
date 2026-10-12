package br.com.biblioteca.exception;

public class LivroIndisponivelException extends Exception{
    public LivroIndisponivelException(){
        super("O livro não está disponível para empréstimo.");
    }
}
