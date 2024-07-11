package biblioteca;

public class StudentUserType extends PunishableUserType {
    public StudentUserType(String name) {
        super(name);
    }

    @Override
    public void addInfraction() {
        this.infractionsCount++;
    }
}

