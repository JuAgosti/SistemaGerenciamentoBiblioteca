package br.com.biblioteca.model;

import br.com.biblioteca.util.IsbnValidator;
import br.com.biblioteca.util.ValidacaoUtil;

import java.util.UUID;

public class Livro {
    private UUID idLivro;
    private String titulo;
    private String autor;
    private String isbn;
    private int anoPublicacao;
    private String genero;
    private StatusEnum statusLivro;

    public Livro(String titulo, String autor, String isbn, int anoPublicacao, String genero) {
        this.idLivro = UUID.randomUUID();
        this.titulo = ValidacaoUtil.validarCampoObrigatorio(titulo,"título");
        this.autor = ValidacaoUtil.validarCampoObrigatorio(autor, "autor");
        this.isbn = IsbnValidator.validar(isbn);
        this.anoPublicacao = validarAnoPublicacao(anoPublicacao);
        this.genero = ValidacaoUtil.validarCampoObrigatorio(genero, "gênero");
        this.statusLivro = StatusEnum.DISPONIVEL;
    }

    public UUID getIdLivro() {
        return idLivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = ValidacaoUtil.validarCampoObrigatorio(titulo, "título");
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = ValidacaoUtil.validarCampoObrigatorio(autor, "autor");
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = IsbnValidator.validar(isbn);
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = validarAnoPublicacao(anoPublicacao);
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = ValidacaoUtil.validarCampoObrigatorio(genero, "gênero");
    }

    public StatusEnum getStatusLivro() {
        return statusLivro;
    }

    public boolean estaDisponivel(){
        return statusLivro == StatusEnum.DISPONIVEL;
    }

    public void marcarEmprestado(){
        statusLivro = StatusEnum.EMPRESTADO;
    }

    public void marcarDisponivel(){
        statusLivro = StatusEnum.DISPONIVEL;
    }

    private int validarAnoPublicacao(int anoPublicacao){
        int anoAtual = java.time.Year.now().getValue();

        if(anoPublicacao <= 0 || anoPublicacao > anoAtual){
            throw new IllegalArgumentException("O ano de publicação deve estar entre 1 e " + anoAtual + ".");
        }
        return anoPublicacao;
    }

}
