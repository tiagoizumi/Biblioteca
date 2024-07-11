package biblioteca;
import java.util.ArrayList;
import java.util.List;

public abstract class User {
    protected String name;
    protected List<Copy> ownedCopies; // passar para a classe Library

    public User(String name) {
        this.name = name;
        this.ownedCopies = new ArrayList<>();
    }

    public void addOwnedCopy (Copy copy) {
        this.ownedCopies.add(copy);
    }
    public boolean removeOwnedCopy (Copy copy) {
        return this.ownedCopies.remove(copy);
    }
    public void consultMyHistory(Library library) {
        library.consultUser(this);
    }

    public String getName() { return this.name; }
    public int countOwnedCopies() { return this.ownedCopies.size(); }
}

