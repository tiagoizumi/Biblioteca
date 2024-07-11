package biblioteca;
import java.util.ArrayList;
import java.util.List;

public class User {
    protected String name;
    protected double infractions = 0; // para se adequar a ideia do staff receber meia punicao mudei para double
    protected List<Copy> ownedCopies; // passar para a classe Library

    public User(String name) {
        this.name = name;
        this.infractions = 0;
        this.ownedCopies = new ArrayList<>();
    }

    public void addOwnedCopy (Copy copy) {
        this.ownedCopies.add(copy);
    }
    public boolean removeCurrentCopy (Copy copy) {
        return this.ownedCopies.remove(copy);
    }
    public void consultMyHistory(Library library) {
        library.consultUser(this);
    }
    public String getName() { return this.name; }
    public double getInfractions() { return this.infractions; }
    public void addInfraction(double increment) { // Mudei aqui tambem para se adequar a ideia de cada user ter uma consequencia
        this.infractions += increment;
    }
    public int countOwnedCopies() { return this.ownedCopies.size(); }
}

