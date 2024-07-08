package biblioteca;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        // Instanciações
        Autor autor1 = new Autor("Ana Almeida");
        Autor autor2 = new Autor("Bernardo Braga");
        Obra calculo1 = new Obra("Cálculo 1", new Autor[]{autor1, autor2});
        Obra geometria1 = new Obra("Geometria Analítica", new Autor[]{autor1, autor2});
        Exemplar calculo01_ex01 = new Exemplar("ob01ex01", calculo1, 1);
        Exemplar geometria01_ex01 = new Exemplar("ob02ex01", geometria1, 1);
        Usuario tiago = new Usuario("Tiago");
        Usuario vitor = new Usuario("Vitor");

        // Vitor não consegue alugar o livro pois já foi alugado por tiago
        tiago.alugar(calculo01_ex01, LocalDate.of(2024, 1, 1));
        vitor.alugar(calculo01_ex01, LocalDate.of(2024, 1, 2));

        // Vitor não consegue devolver o livro emprestado por tiago
        vitor.devolver(calculo01_ex01, LocalDate.of(2024, 1, 3));

        tiago.alugar(geometria01_ex01, LocalDate.of(2024,7,2));
        tiago.devolver(geometria01_ex01, LocalDate.of(2024, 7, 3));

        tiago.consultarHistorico();
    }
}
