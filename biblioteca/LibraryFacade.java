package biblioteca;
import java.time.LocalDate;

public class LibraryFacade {
    private AprovationHandler chain;
    private Library library;

    public LibraryFacade(Library library) {
        this.library = library;

        this.chain = new BookAvailabilityHandler();
        Handler userEligibility = new UserEligibilityHandler(); 
        Handler loanLimit = new LoanLimitHandler();

        chain.setNextHandler(userEligibility);
        userEligibility.setNextHandler(loanLimit);
    }

    public boolean loan(User user, Copy copy, LocalDate loanDate) {
        boolean available = this.chain.handleRequest(user, copy);
        if (available) {
            this.library.registerLoan(user, copy, loanDate);
            copy.setBorrowedBy(user);
            user.addOwnedCopy(copy);
            System.out.println("Emprestado!");
            return true;
        }
        return false;
    }
}