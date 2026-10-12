package br.com.biblioteca.exception;

public class NaoEncontradaException extends Exception{
    public NaoEncontradaException(String tipo){
        super(tipo + " não encontrada.");
    }
}
