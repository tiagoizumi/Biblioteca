package biblioteca;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<Copy> currentCopies;

    public User(String name) {
        this.name = name;
        this.currentCopies = new ArrayList<>();
    }

    public String getName() {return name;}
    public void addCurrentCopy (Copy copy) {
        this.currentCopies.add(copy);
    }
    public boolean removeCurrentCopy (Copy copy) {
        return this.currentCopies.remove(copy);
    }
}

