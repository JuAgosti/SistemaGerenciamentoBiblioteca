package br.com.biblioteca.model;

import br.com.biblioteca.exception.CampoObrigatorioException;
import br.com.biblioteca.exception.LivroIndisponivelException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class Emprestimo {
    private final UUID idEmprestimo;
    private final Livro livro;
    private final Usuario usuario;
    private final LocalDate dataEmprestimo;
    private final LocalDate dataPrevistaDevolucao;
    private LocalDate dataDevolucao;

    private static final BigDecimal MULTA_POR_DIA = new BigDecimal("2.00");
    private static final int PRAZO_DIAS = 14;

    public Emprestimo(Livro livro, Usuario usuario, LocalDate dataEmprestimo) throws LivroIndisponivelException {
        this.idEmprestimo = UUID.randomUUID();
        this.livro = validaLivro(livro);
        this.usuario = validarUsuario(usuario);
        this.dataEmprestimo = validarDataEmprestimo(dataEmprestimo);
        this.dataPrevistaDevolucao = this.dataEmprestimo.plusDays(PRAZO_DIAS);
        this.livro.marcarEmprestado();
    }

    public UUID getIdEmprestimo() {
        return idEmprestimo;
    }

    public Livro getLivro() {
        return livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    private Livro validaLivro(Livro livro) throws LivroIndisponivelException{
        if(livro == null){
            throw new CampoObrigatorioException("livro");
        }

         if(!livro.estaDisponivel()){
             throw new LivroIndisponivelException();
         }

        return livro;
    }

    private Usuario validarUsuario(Usuario usuario){
        if(usuario == null){
            throw new CampoObrigatorioException("usuário");
        }
        return usuario;
    }

    private LocalDate validarDataEmprestimo(LocalDate data){
        if(data == null){
            throw new CampoObrigatorioException("data empréstimo");
        }
        return data;
    }

    public boolean estaEmAberto() {
        return dataDevolucao == null;
    }

    public boolean estaAtrasado(){
        LocalDate dataReferencia = estaEmAberto() ? LocalDate.now() : dataDevolucao;

        return dataReferencia.isAfter(dataPrevistaDevolucao);
    }

    public long calcularDiasAtraso(){
        LocalDate dataReferencia = estaEmAberto() ? LocalDate.now() : dataDevolucao;

        if(!dataReferencia.isAfter(dataPrevistaDevolucao)){
            return 0;
        }

        return java.time.temporal.ChronoUnit.DAYS.between( dataPrevistaDevolucao, dataReferencia);
    }

    public BigDecimal calcularMulta(){
        return MULTA_POR_DIA.multiply(BigDecimal.valueOf(calcularDiasAtraso()));
    }

    public void registrarDevolucao(LocalDate dataDevolucao){
        if(dataDevolucao == null){
            throw new CampoObrigatorioException("data devolução");
        }

        if(!estaEmAberto()){
            throw new IllegalStateException("Este empréstimo já foi devolvido");
        }

        if (dataDevolucao.isBefore(dataEmprestimo)){
            throw new IllegalArgumentException("A devolução não pode ocorrer antes do empréstimo");
        }

        this.dataDevolucao = dataDevolucao;
        this.livro.marcarDisponivel();
    }
}
