package biblioteca;

public class UserEligibilityHandler extends AprovationHandler {
    private ConfigurationManager configs;
    @Override
    public boolean handleRequest(User user, Copy copy) {
        configs = ConfigurationManager.getInstance();
        if (user instanceof PunishableUserType) {
            PunishableUserType punishableUser = (PunishableUserType) user;
            if (punishableUser.getInfractionsCount() > configs.getInfractionsLimit()){
                System.out.println("Número de infrações excedido!");
                return false;
            }
        }
        
        if (this.nextHandler != null) {
            return this.nextHandler.handleRequest(user, copy);
        }
        else {
            return true;
        }
    }
}