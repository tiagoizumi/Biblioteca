package biblioteca;

public class StaffUserType extends PunishableUserType {
    public StaffUserType(String name) {
        super(name);
    }

    // VERIFICAR SE FAZ SENTIDO
    // Os funcionários conseguem ver o histórico de qualquer usuário
    public void consultUserHistory(User user, Library library) {
        library.consultUser(user);
    }
    
    @Override
    public void addInfraction() {
        this.infractionsCount += 0.5;
    }

}

