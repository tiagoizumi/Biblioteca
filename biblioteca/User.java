package biblioteca;
import java.util.ArrayList;
import java.util.List;


public abstract class User implements Observer {  
    protected String name;
    protected List<Copy> ownedCopies;

    public User(String name) {
        this.name = name;
        this.ownedCopies = new ArrayList<>();
    }

    public boolean addOwnedCopy (Copy copy) {
        return this.ownedCopies.add(copy);
    }
    public boolean removeOwnedCopy (Copy copy) {
        return this.ownedCopies.remove(copy);
    }
    public void consultMyHistory(Library library) {
        library.consultUser(this);
    }
    @Override // Notificações
    public void update(String message) {
        System.out.println(name + ", you have a new notification: " + message);
    }

    public String getName() { return this.name; }
    public int countOwnedCopies() { return this.ownedCopies.size(); }
}

