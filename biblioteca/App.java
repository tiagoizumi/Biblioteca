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
        User tiago = new StaffUserType("Tiago");
        User vitor = new StudentUserType("Vitor");
        ConfigurationManager configs;

        configs = ConfigurationManager.getInstance();

        Library library = new Library();
        LibraryFacade libraryFacade = new LibraryFacade(library);
    
        libraryFacade.loan(tiago, geometria01_ex01, LocalDate.of(2024, 1, 2));
        geometria1.attach(vitor);

        libraryFacade.returnBook(tiago, geometria01_ex01, LocalDate.of(2024,2,3));

        libraryFacade.loan(tiago, calculo01_ex01, LocalDate.of(2024, 1, 1));
        library.consultHistory();
    }
}
