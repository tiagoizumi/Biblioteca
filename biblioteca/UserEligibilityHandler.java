package biblioteca;

public class UserEligibilityHandler extends AprovationHandler {
    @Override
    public boolean handleRequest(User user, Copy copy) {

        if (user instanceof PunishableUserType) {
            PunishableUserType punishableUser = (PunishableUserType) user;
            if (punishableUser.getInfractionsCount() > 5){ ///////////////////////////////// CONFIGURAR PELO SINGLETON
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