package biblioteca;
import java.time.LocalDate;

public class LibraryFacade {
    private AprovationHandler chain;
    private Library library;

    public LibraryFacade(Library library) {
        this.library = library;

        // Chain of responsability
        this.chain = new BookAvailabilityHandler();
        Handler userEligibility = new UserEligibilityHandler(); 
        Handler loanLimit = new LoanLimitHandler();
        this.chain.setNextHandler(userEligibility);
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

    public boolean returnBook(User user, Copy copy, LocalDate giveBackDate) {
        if (user == copy.getBorrowedBy()) {
            this.library.registerReturn(user, copy, giveBackDate);
            copy.setBorrowedBy(null);
            user.removeOwnedCopy(copy);

            return true;
        }
        return false;
    }

    public void addUserToNotificationList(User user, Work work) {
        work.attach(user);
    }

    public void removeUserToNotificationList(User user, Work work) {
        work.detach(user);
    }
}