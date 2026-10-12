package br.com.biblioteca;
import br.com.biblioteca.util.IsbnValidator;

public class Main {

    public static void main(String[] args) {

        String[] isbns = {
                "978-3-16-148410-0",
                "0306406152",
                "1234567890123",
                "123"
        };

        for (String isbn : isbns) {
            try {
                String isbnValidado = IsbnValidator.validar(isbn);

                System.out.println(
                        "ISBN válido: " + isbnValidado
                );

            } catch (IllegalArgumentException e) {
                System.out.println(
                        "ISBN inválido: " + isbn
                                + " | Motivo: " + e.getMessage()
                );
            }
        }
    }
}
