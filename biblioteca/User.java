package biblioteca;
import java.util.ArrayList;
import java.util.List;

public abstract class User {
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
    public abstract void addInfraction(); // Essa função será diferente para cada tipo de usuário

    public String getName() { return this.name; }
    public double getInfractions() { return this.infractions; }
    public int countOwnedCopies() { return this.ownedCopies.size(); }
}

