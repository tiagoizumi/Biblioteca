package biblioteca;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Loan {
    private User user;
    private Copy copy;
    private LocalDate loanDate;
    private LocalDate returnDate;

    public Loan(User user, Copy copy, LocalDate loanDate) {
        this.user = user;
        this.copy = copy;
        this.loanDate = loanDate;
        this.returnDate = null;
    }

    public boolean returned() {return this.returnDate != null;}

    public Copy getCopy() {return copy;}

    public void registerReturn(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public void printInfo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String loanDateStr = loanDate.format(formatter);
        String returnDateStr = (returnDate != null) ? returnDate.format(formatter) : "N/A";
        String title = copy.getTitle();
        System.out.format("%-20s %-20s %-15s %-15s %-10s%n", 
                          user.getName(), title, loanDateStr, returnDateStr, this.returned() ? "Sim" : "Não");
    }
}
