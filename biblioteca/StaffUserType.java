package biblioteca;


public class StaffUserType extends User {
    public StaffUserType(String name) {
        super(name);
    }

    @Override
    public void addOwnedCopy(Copy copy) {
        // LOGICA DO FUNCIONARIO AINDA NAO SEI COMO DIFERENCIAR
        this.ownedCopies.add(copy);
    }
}

