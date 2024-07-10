package biblioteca;

public class StudentUserType extends User {
    public StudentUserType(String name) {
        super(name);
    }

    @Override
    public void addOwnedCopy(Copy copy) {
        // LOGICA DO ESTUDANTE AINDA NAO SEI COMO DIFERENCIAR
        this.ownedCopies.add(copy);
    }

    @Override
    public boolean removeOwnedCopy(Copy copy) {
        // LOGICA DO ESTUDANTE AINDA NAO SEI COMO DIFERENCIAR
        return this.ownedCopies.remove(copy);
    }
}

