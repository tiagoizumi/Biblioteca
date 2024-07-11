package biblioteca;

// Seguindo o pirncípio de Liskov
public abstract class PunishableUserType extends User {
    protected double infractionsCount;
    private ConfigurationManager config;

    public PunishableUserType(String name) {
        super(name);
        this.infractionsCount = 0;
        this.config = ConfigurationManager.getInstance();
    }
    public double getInfractionsCount() { return this.infractionsCount; }
    public abstract void addInfraction();

    @Override
    public void consultMyHistory(Library library) {
        System.out.println("Infrações: " + this.infractionsCount + "/" + this.config.getInfractionsLimit() ); 
        library.consultUser(this);
    }
}