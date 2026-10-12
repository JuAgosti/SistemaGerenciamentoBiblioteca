package br.com.biblioteca.exception;

public class CampoObrigatorioException extends RuntimeException{
    public CampoObrigatorioException(String nomeCampo){
        super("O campo " + nomeCampo + " não pode ser vazio.");
    }
}
