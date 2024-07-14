package biblioteca;

import java.time.LocalDate;
import java.util.List;

public class LibraryFacade implements LibraryMediator {
    private AprovationHandler chain;
    private Library library;
    private ConfigurationManager configs;

    public LibraryFacade(Library library) {
        this.library = library;

        // Chain of Responsibility
        this.chain = new BookAvailabilityHandler();
        Handler userEligibility = new UserEligibilityHandler(); 
        Handler loanLimit = new LoanLimitHandler();
        this.chain.setNextHandler(userEligibility);
        userEligibility.setNextHandler(loanLimit);
    }

    @Override
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

    @Override
    public boolean returnBook(User user, Copy copy, LocalDate giveBackDate) {
        if (user == copy.getBorrowedBy()) {
            this.library.registerReturn(user, copy, giveBackDate);
            copy.setBorrowedBy(null);
            user.removeOwnedCopy(copy);
            return true;
        }
        return false;
    }

    @Override
    public void addUserToNotificationList(User user, Work work) {
        work.attach(user);
    }

    @Override
    public void removeUserToNotificationList(User user, Work work) {
        work.detach(user);
    }

    @Override
    public void displayCategories() {
        configs = ConfigurationManager.getInstance();
        configs.displayCategories();
    }

    @Override
    public List<Work> searchByName(String name) {
        SearchCriteria titleSearch = new TitleSearch();
        List<Work> searchResults = library.search(titleSearch, name);
        for (Work work : searchResults) {
            System.out.println("Found: " + work.getTitle());
        }
        return searchResults;
    }

    @Override
    public List<Work> searchByAuthor(String name) {
        SearchCriteria authorSearch = new AuthorSearch();
        List<Work> searchResults = library.search(authorSearch, name);
        for (Work work : searchResults) {
            System.out.println("Found: " + work.getTitle());
        }
        return searchResults;
    }

    @Override
    public List<Work> searchByCategory(String name) {
        SearchCriteria categorySearch = new CategorySearch();
        List<Work> searchResults = library.search(categorySearch, name);
        for (Work work : searchResults) {
            System.out.println("Found by category: " + work.getTitle());
        }
        return searchResults;
    }
}
