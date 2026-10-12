
package br.com.biblioteca.util;

public final class IsbnValidator {

    private IsbnValidator() {
        // Impede a criação de objetos dessa classe utilitária
    }

    public static String validar(String isbn) {

        if (isbn == null || isbn.isBlank()) {
            throw new IllegalArgumentException(
                    "O ISBN não pode ser vazio."
            );
        }

        // Remove hífens e espaços.
        String isbnNormalizado = isbn.replace("-", "")
                .replace(" ", "");

        // Verifica se é um ISBN-10.
        if (isbnNormalizado.matches("[0-9]{9}[0-9Xx]")) {

            if (!validarIsbn10(isbnNormalizado)) {
                throw new IllegalArgumentException(
                        "O ISBN-10 informado é inválido."
                );
            }

            return isbnNormalizado.toUpperCase();
        }

        // Verifica se é um ISBN-13.
        if (isbnNormalizado.matches("[0-9]{13}")) {

            if (!validarIsbn13(isbnNormalizado)) {
                throw new IllegalArgumentException(
                        "O ISBN-13 informado é inválido."
                );
            }

            return isbnNormalizado;
        }

        throw new IllegalArgumentException(
                "O ISBN deve possuir 10 ou 13 caracteres válidos."
        );
    }

    private static boolean validarIsbn10(String isbn) {

        int soma = 0;

        for (int i = 0; i < 10; i++) {

            char caractere = isbn.charAt(i);

            int digito;

            if (i == 9 && (caractere == 'X' || caractere == 'x')) {
                digito = 10;
            } else {
                digito = Character.getNumericValue(caractere);
            }

            soma += digito * (10 - i);
        }

        return soma % 11 == 0;
    }

    private static boolean validarIsbn13(String isbn) {

        int soma = 0;

        for (int i = 0; i < 12; i++) {

            int digito = Character.getNumericValue(isbn.charAt(i));

            if (i % 2 == 0) {
                soma += digito;
            } else {
                soma += digito * 3;
            }
        }

        int digitoCalculado = (10 - (soma % 10)) % 10;

        int ultimoDigito = Character.getNumericValue(
                isbn.charAt(12)
        );

        return digitoCalculado == ultimoDigito;
    }
}
