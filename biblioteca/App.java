package biblioteca;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        // Instanciações
        Author autor1 = new Author("Ana Almeida");
        Author autor2 = new Author("Bernardo Braga");
        Work calculo1 = new Work("Cálculo 1", new Author[]{autor1, autor2});
        Work geometria1 = new Work("Geometria Analítica", new Author[]{autor1, autor2});
        Copy calculo01_ex01 = new Copy("ob01ex01", calculo1, 1);
        Copy geometria01_ex01 = new Copy("ob02ex01", geometria1, 1);
        User tiago = new User("Tiago");
        User vitor = new User("Vitor");  // OLHA EU AQUI OH PQ TA COM ESSE ERRO? EU SOU BURRO?

        Library library = new Library();
        LibraryFacade libraryFacade = new LibraryFacade(library);
        
        tiago.addInfraction();
        tiago.addInfraction();
        tiago.addInfraction();
        
        libraryFacade.loan(tiago, calculo01_ex01, LocalDate.of(2024, 1, 1));
        libraryFacade.loan(tiago, geometria01_ex01, LocalDate.of(2024, 1, 2));
        libraryFacade.loan(vitor, calculo01_ex01, LocalDate.of(2024, 1, 2));

    }
}
