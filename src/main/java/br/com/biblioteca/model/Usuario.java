package br.com.biblioteca.model;

import br.com.biblioteca.exception.CampoObrigatorioException;
import br.com.biblioteca.util.CpfValidator;
import br.com.biblioteca.util.ValidacaoUtil;

import java.util.UUID;

public class Usuario {
    private UUID idUsuario;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;

    public Usuario(String nome, String cpf, String email, String telefone) {
        this.idUsuario = UUID.randomUUID();
        this.nome = ValidacaoUtil.validarCampoObrigatorio(nome, "nome");
        this.cpf = CpfValidator.validar(cpf);
        this.email = validarEmail(email);
        this.telefone = validarTelefone(telefone);
    }

    public UUID getIdUsuario() {
        return idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = ValidacaoUtil.validarCampoObrigatorio(nome, "nome");
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = CpfValidator.validar(cpf);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = validarEmail(email);
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = validarTelefone(telefone);
    }

    private String validarEmail(String email) {
        if (email == null || !email.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) {
            throw new IllegalArgumentException("E-mail inválido.");
        }

        String emailNormalizado = email.trim();

        if (!emailNormalizado.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) {
            throw new IllegalArgumentException("E-mail inválido.");
        }

        return email;
    }

    private String validarTelefone(String telefone){
        if( telefone == null || telefone.isBlank()){
            throw new CampoObrigatorioException("telefone");
        }

        String telefoneNormalizado = telefone.replaceAll("\\D", "");

        if(!telefoneNormalizado.matches("\\d{10,11}")){
            throw new IllegalArgumentException("O telefone deve possuir DDD e 10 ou 11 dígitos");
        }

        return telefoneNormalizado;
    }
}
