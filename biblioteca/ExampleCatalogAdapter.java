package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class ExampleCatalogAdapter implements ExternalCatalogAdapter {
    @Override
    public List<Work> fetchWorks() {
        List<Work> externalWorks = new ArrayList<>();

        // Simulando alguns dados de obras externas
        Author author1 = new Author("External Author One");
        Author author2 = new Author("External Author Two");
        Author[] authors1 = {author1};
        Author[] authors2 = {author2};

        Work externalWork1 = new Work("External Title One", authors1);
        Work externalWork2 = new Work("External Title Two", authors2);

        externalWorks.add(externalWork1);
        externalWorks.add(externalWork2);

        return externalWorks;
    }
}
