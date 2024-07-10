package biblioteca;
import java.util.ArrayList;
import java.util.List;

public abstract class User {
    protected String name;
    protected int infractions;
    protected List<Copy> ownedCopies;

    public User(String name) {
        this.name = name;
        this.infractions = 0;
        this.ownedCopies = new ArrayList<>();
    }

    public abstract void addOwnedCopy(Copy copy);
    public abstract boolean removeOwnedCopy(Copy copy);

    public String getName() { return this.name; }
    public int getInfractions() { return this.infractions; }
    public void addInfraction() { 
        this.infractions++; 
    }
    public int countOwnedCopies() { return this.ownedCopies.size(); }
}

