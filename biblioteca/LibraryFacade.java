package biblioteca;
import java.time.LocalDate;

public class LibraryFacade {

    private AprovationHandler chain;
    private Library library;

    public LibraryFacade(Library library) {
        this.chain = new BookAvailabilityHandler();
        this.library = library;
    }

    public boolean loan(User user, Copy copy, LocalDate loanDate) {
        boolean available;
        available = this.chain.handleRequest(copy);

        if (available) {
            this.library.registerLoan(user, copy, loanDate);
            return true;
        }
        return false;
    }
}