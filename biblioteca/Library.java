package biblioteca;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

public class Library {
    private List<Loan> loanList;
    
    public Library() {
        this.loanList = new ArrayList<>();
    }

    public void registerLoan(User user, Copy copy, LocalDate loanDate) {
        loanList.add(new Loan(user, copy, loanDate));
    }
}
