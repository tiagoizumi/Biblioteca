package biblioteca;

// Seguindo o pirncípio de Liskov
public abstract class PunishableUserType extends User {
    protected double infractionsCount;

    public PunishableUserType(String name) {
        super(name);
        this.infractionsCount = 0;
    }
    public double getInfractionsCount() { return this.infractionsCount; }
    public abstract void addInfraction();

    @Override
    public void consultMyHistory(Library library) {
        System.out.println("Infrações: " + this.infractionsCount + "/5" ); ////////////////////////// CONFIGURAR PELO SINGLETON
        library.consultUser(this);
    }
}