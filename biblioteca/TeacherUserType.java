package biblioteca;


public class TeacherUserType extends User {
    public TeacherUserType(String name) {
        super(name);
    }

    @Override
    public void addOwnedCopy(Copy copy) {
        // Lógica dos PROFESSORES
        this.ownedCopies.add(copy);
    }
    
}