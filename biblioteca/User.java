package biblioteca;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<Copy> owndedCopies;
    private int infractions;

    public User(String name) {
        this.name = name;
        this.owndedCopies = new ArrayList<>();
        this.infractions = 0;
    }

    public void addOwndedCopy (Copy copy) {
        this.owndedCopies.add(copy);
    }
    public boolean removeCurrentCopy (Copy copy) {
        return this.owndedCopies.remove(copy);
    }
    
    public String getName() {return this.name;}
    public int getInfractions() {return this.infractions;}
    public int countOwndedCopies() {
        System.err.println(this.owndedCopies.size());
        return this.owndedCopies.size();
    }
    public void addInfraction() {
        this.infractions++;
    }
}

