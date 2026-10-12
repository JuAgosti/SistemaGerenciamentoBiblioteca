
package br.com.biblioteca;

import br.com.biblioteca.exception.CampoObrigatorioException;
import br.com.biblioteca.model.Usuario;
import br.com.biblioteca.util.CpfValidator;

public class Main {

    public static void main(String[] args) {
        testarCpf("529.982.247-25");
        testarCpf("111.111.111-11");
        testarCpf("529.982.247-24");
        testarCpf("123");
        testarCpf("");
        testarCpf(null);

        testarUsuario();
    }

    private static void testarCpf(String cpf) {
        try {
            String cpfValidado = CpfValidator.validar(cpf);

            System.out.println(
                    "CPF: " + cpf + " -> VÁLIDO (" + cpfValidado + ")"
            );

        } catch (CampoObrigatorioException e) {
            System.out.println("CPF: " + cpf
                    + " -> INVÁLIDO: " + e.getMessage());

        } catch (IllegalArgumentException e) {
            System.out.println("CPF: " + cpf
                    + " -> INVÁLIDO: " + e.getMessage());
        }
    }

    private static void testarUsuario() {
        try {
            Usuario usuario = new Usuario(
                    "Maria da Silva",
                    "529.982.247-25",
                    "maria@email.com",
                    "(51) 99999-9999"
            );

            System.out.println("\n--- Usuário cadastrado ---");
            System.out.println("ID: " + usuario.getIdUsuario());
            System.out.println("Nome: " + usuario.getNome());
            System.out.println("CPF: " + usuario.getCpf());
            System.out.println("E-mail: " + usuario.getEmail());
            System.out.println("Telefone: " + usuario.getTelefone());

        } catch (CampoObrigatorioException e) {
            System.out.println("Erro ao cadastrar usuário: " + e.getMessage());

        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
        }
    }
}
