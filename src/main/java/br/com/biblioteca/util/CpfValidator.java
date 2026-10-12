package br.com.biblioteca.util;

import br.com.biblioteca.exception.CampoObrigatorioException;

public final class CpfValidator {

    private CpfValidator() {
    }

    public static String validar(String cpf) {
        if (cpf == null || cpf.isBlank()) {
            throw new CampoObrigatorioException("CPF");
        }

        // Remove pontos, hífens e outros caracteres que não sejam números.
        String cpfNormalizado = cpf.replaceAll("\\D", "");

        // O CPF deve possuir exatamente 11 dígitos.
        if (!cpfNormalizado.matches("\\d{11}")) {
            throw new IllegalArgumentException(
                    "O CPF deve possuir 11 dígitos."
            );
        }

        // Rejeita CPFs formados pelo mesmo dígito repetido.
        if (cpfNormalizado.matches("(\\d)\\1{10}")) {
            throw new IllegalArgumentException(
                    "O CPF informado é inválido."
            );
        }

        // Valida o primeiro e o segundo dígito verificador.
        if (!validarDigitosVerificadores(cpfNormalizado)) {
            throw new IllegalArgumentException(
                    "O CPF informado é inválido."
            );
        }

        return cpfNormalizado;
    }

    private static boolean validarDigitosVerificadores(String cpf) {
        int primeiroDigito = calcularDigito(cpf, 9);
        int segundoDigito = calcularDigito(cpf, 10);

        return primeiroDigito == Character.getNumericValue(cpf.charAt(9))
                && segundoDigito == Character.getNumericValue(cpf.charAt(10));
    }

    private static int calcularDigito(String cpf, int quantidadeDigitos) {
        int soma = 0;

        for (int i = 0; i < quantidadeDigitos; i++) {
            int digito = Character.getNumericValue(cpf.charAt(i));
            soma += digito * (quantidadeDigitos + 1 - i);
        }

        int resto = soma % 11;

        return resto < 2 ? 0 : 11 - resto;
    }
}
