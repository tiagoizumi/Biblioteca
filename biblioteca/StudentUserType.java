package biblioteca;

public class StudentUserType extends User {
    public StudentUserType(String name) {
        super(name);
    }

    @Override
    public void addOwnedCopy(Copy copy) {
        // LOGICA DO ESTUDANTE AINDA NAO SEI COMO DIFERENCIAR
        if (this.ownedCopies.size() >= 1) {
            System.out.println("Cannot rent more than one book at a time.");
            return;
        }
        this.ownedCopies.add(copy);
    }

    @Override
    public void addInfraction() {
        this.infractions++;
    }
}

