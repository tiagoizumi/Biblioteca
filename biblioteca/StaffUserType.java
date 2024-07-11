package biblioteca;

public class StaffUserType extends User {
    public StaffUserType(String name) {
        super(name);
    }

    // os funcionários conseguem ver o histórico de qualquer usuário
    public void consultUserHistory(User user, Library library) {
        library.consultUser(user);
    }
    @Override
    public void addInfraction() {
        this.infractions += 0.5;
    }

}

