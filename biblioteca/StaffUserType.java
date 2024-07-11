package biblioteca;


public class StaffUserType extends User {
    public StaffUserType(String name) {
        super(name);
    }

    // os funcionários conseguem ver o histórico de qualquer usuário
    public void consultUserHistory(User user, Library library) {
        library.consultUser(user);
    }
    public void addInfraction() { // Não sei se a ideia de criar uma função com o mesmo nome e chamar a outra com o mesmo nome ta certo
        super.addInfraction(0.5); // Pass 0.5 as the increment for staff members
    }

}

