package biblioteca;

public class BookAvailabilityHandler extends AprovationHandler{
    @Override
    public boolean handleRequest(User user, Copy copy) {
        if (!copy.isAvailable()) {
            System.out.println("Livro indisponível!");
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