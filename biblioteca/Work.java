package biblioteca;
import java.util.List;
import java.util.ArrayList;

public class Work {
    private String title;
    private Author[] authors;
    private List<Copy> copies;

    public Work(String title, Author[] authors) {
        this.title = title;
        this.authors = authors;
        this.copies = new ArrayList<>();
    }

    public void addCopy(Copy copy) {
        copies.add(copy);
    }

    // getters
    public String getTitle() {return this.title;}
    public Author[] getAuotres() {return this.authors;}
    public List<Copy> getCopies() {return this.copies;}
}
