package biblioteca;

import java.time.LocalDate;
import java.util.List;

public interface LibraryMediator {
    boolean loan(User user, Copy copy, LocalDate loanDate);
    boolean returnBook(User user, Copy copy, LocalDate giveBackDate);
    void addUserToNotificationList(User user, Work work);
    void removeUserToNotificationList(User user, Work work);
    void displayCategories();
    List<Work> searchByName(String name);
    List<Work> searchByAuthor(String name);
    List<Work> searchByCategory(String name);
}