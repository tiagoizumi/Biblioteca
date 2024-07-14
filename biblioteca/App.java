package biblioteca;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        // Instanciações
        ConfigurationManager configs;
        Author autor1 = new Author("Ana Almeida");
        Author autor2 = new Author("Bernardo Braga");
        BookCategory catMatematica = new BookCategory("Matemática");
        BookCategory catGeometria = new BookCategory("Geometria");
        BookCategory catCalculo = new BookCategory("Cálculo");
        Work calculo1 = new Work("Cálculo 1", new Author[]{autor1, autor2});
        Work calculo2 = new Work("Cálculo 2", new Author[]{autor1, autor2});
        Work geometria1 = new Work("Geometria Analítica", new Author[]{autor1, autor2});
        Copy calculo01_ex01 = new Copy("ob01ex01", calculo1, 1);
        Copy geometria01_ex01 = new Copy("ob02ex01", geometria1, 1);
        User tiago = new StaffUserType("Tiago");
        User vitor = new StudentUserType("Vitor");

        configs = ConfigurationManager.getInstance();
        configs.setInfractionsLimit(4);
        
        // Hierarquia de categorias
        BookCategory rootCategory = configs.getBookCategory();
        rootCategory.addItem(catMatematica);
        catMatematica.addItem(catGeometria);
        catMatematica.addItem(catCalculo);
        catGeometria.addItem(geometria1.getWorkItem());
        catCalculo.addItem(calculo1.getWorkItem());
        catCalculo.addItem(calculo2.getWorkItem());

        Library library = new Library();
        LibraryFacade facade = new LibraryFacade(library);

        library.addWork(geometria1);
        library.addWork(calculo1);
        library.addWork(calculo2);

        // facade.searchByName("cálculo 1");
        facade.searchByAuthor("cálculo 1");

        calculo1.consultInfo();

        // libraryFacade.loan(tiago, geometria01_ex01, LocalDate.of(2024, 1, 2));
        // geometria1.attach(vitor);

        // libraryFacade.returnBook(tiago, geometria01_ex01, LocalDate.of(2024,2,3));

        // libraryFacade.loan(tiago, calculo01_ex01, LocalDate.of(2024, 1, 1));
        // library.consultHistory();

        // facade.displayCategories();
    }
}
