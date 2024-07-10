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

    public void consultUser(User user) {
        // colocar o cabeçalho aqui --------------------------------------------
        for (Loan loan : this.loanList) {
            if (loan.getUser() == user) {
                loan.printInfo();
            }
        }
    }
}
