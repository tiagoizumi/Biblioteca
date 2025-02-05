package biblioteca;
import java.util.List;
import java.util.ArrayList;

public class Work extends Observable {
    private String title;
    private Author[] authors;
    private List<Copy> copies;
    private WorkItem workItem;
    private BookCategory category;

    public Work(String title, Author[] authors) {
        this.title = title;
        this.authors = authors;
        this.copies = new ArrayList<>();
        this.workItem = new WorkItem(this);
        this.category = null;
    }

    public void addCopy(Copy copy) {
        copies.add(copy);

    }

    public void consultInfo() {
        System.out.println("Título: " + this.title);
        System.out.println("Autores: ");
        for (Author autor : this.authors) {
            System.out.println(autor.getName());
        }
        System.out.println("Categoria: " + this.category.getName());

        int available = 0;
        for (Copy copy : this.copies){
            if (copy.isAvailable()) {
                available++;
            }
        }
        System.out.println("Cópias disponíveis: " + available);
    }

    // getters
    public String getTitle() {return this.title;}
    public Author[] getAuothors() {return this.authors;}
    public List<Copy> getCopies() {return this.copies;}
    public WorkItem getWorkItem() {return workItem;}
    public Author[] getAuthors() {return authors;}
    public BookCategory getCategory() {return category;}
    public String getCategoryString() {return category.getName();}

    // setters
    public void setCategory(BookCategory category) {this.category = category;}
}
