package biblioteca;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Loan {
    private static final int STUDENT_LOAN_PERIOD = 15;
    private static final int STAFF_LOAN_PERIOD = 20;
    private static final int TEACHER_LOAN_PERIOD = 30;

    private User user;
    private Copy copy;
    private LocalDate loanDate;
    private LocalDate returnDate;
    private LocalDate returnDeadline;

    public Loan(User user, Copy copy, LocalDate loanDate) {
        this.user = user;
        this.copy = copy;
        this.loanDate = loanDate;
        this.returnDate = null;
        this.returnDeadline = loanDate.plusDays(getLoanPeriod(user));
    }

    public boolean returned() {return this.returnDate != null;}

    public Copy getCopy() {return this.copy;}
    public User getUser() {return this.user;}
    public LocalDate getReturnDeadline() {return returnDeadline;}

    public void setReturnDate(LocalDate returnDate) {
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

    private int getLoanPeriod(User user) {
        if (user instanceof StudentUserType) {
            return STUDENT_LOAN_PERIOD;
        } else if (user instanceof StaffUserType) {
            return STAFF_LOAN_PERIOD;
        } else if (user instanceof TeacherUserType) {
            return TEACHER_LOAN_PERIOD;
        }
        throw new IllegalArgumentException("Tipo inválido de usuário" + user.getClass().getSimpleName());
    }
}
