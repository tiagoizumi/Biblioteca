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

    @Override
    public void addInfraction(double increment) {
    // Não faz nada, professores não recebem infrações, provavelmente existe uma maneira melhor de fazer isso
}
    
}