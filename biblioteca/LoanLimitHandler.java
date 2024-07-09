package biblioteca;

public class LoanLimitHandler extends AprovationHandler {
    @Override
    public boolean handleRequest(User user, Copy copy) {
        if (user.countOwndedCopies() >= 1) {
            System.out.println("Limite de livros excedido!");
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
