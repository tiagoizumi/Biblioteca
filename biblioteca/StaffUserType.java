package biblioteca;

public class StaffUserType extends PunishableUserType {
    private ConfigurationManager configs;
    public StaffUserType(String name) {
        super(name);
        this.configs = ConfigurationManager.getInstance();
    }

    // Os funcionários conseguem ver o histórico de qualquer usuário
    public void consultUserHistory(User user, Library library) {
        library.consultUser(user);
    }
    
    @Override
    public void addInfraction() {
        this.infractionsCount += configs.getStaffInfractionIncrement();
    }

}

