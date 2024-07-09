package biblioteca;

public class UserEligibilityHandler extends AprovationHandler {
    @Override
    public boolean handleRequest(User user, Copy copy) {
        int infractions = user.getInfractions();
        if (infractions > 2) {
            System.out.println("Número de infrações excedido!");
            return false;
        }
        else if (this.nextHandler != null) {
            return this.nextHandler.handleRequest(user, copy);
        }
        else {
            return true;
        }
    }
}