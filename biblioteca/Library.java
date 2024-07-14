package biblioteca;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

public class Library{ 
    private List<Loan> returnedList;
    private List<Loan> pendentList;
    private List<Work> works;
    private List<ExternalCatalogAdapter> adapters;
    
    public Library() {
        this.returnedList = new ArrayList<>();
        this.pendentList = new ArrayList<>();
        this.works = new ArrayList<>();
        this.adapters = new ArrayList<>();
    }

    public void registerLoan(User user, Copy copy, LocalDate loanDate) {
        this.pendentList.add(new Loan(user, copy, loanDate));
    }

    public void registerReturn(User user, Copy copy, LocalDate returnDate) {
        for (Loan pendentLoan : this.pendentList) {
            if (pendentLoan.getCopy() == copy && pendentLoan.getUser() == user) {

                if (returnDate.isAfter(pendentLoan.getReturnDeadline()) && user instanceof PunishableUserType) { // Entrega atrasada
                    PunishableUserType punishable = (PunishableUserType) user;
                    punishable.addInfraction();
                }

                pendentList.remove(pendentLoan);
                pendentLoan.setReturnDate(returnDate);
                returnedList.add(pendentLoan);
                copy.getWork().bookStatusChanged(copy);
                break;
            }
        }
    }

    public void consultUser(User user) {
        System.out.format("%-20s %-20s %-15s %-15s %-10s%n", 
        "Nome", "Livro", "Empréstimo", "Devolução", "Devolvido");
        for (Loan loan : this.returnedList) {
            if (loan.getUser() == user) {
                loan.printInfo();
            }
        }
        for (Loan loan : this.pendentList) {
            if (loan.getUser() == user) {
                loan.printInfo();
            }
        }
        System.out.println();
    }

    public void consultHistory() {
        System.out.format("%-20s %-20s %-15s %-15s %-10s%n", 
        "Nome", "Livro", "Empréstimo", "Devolução", "Devolvido");
        for (Loan loan : this.returnedList){
            loan.printInfo();
        }
        for (Loan loan : this.pendentList) {
            loan.printInfo();
        }
        System.out.println();
    }


    public void addAdapter(ExternalCatalogAdapter adapter) {
        adapters.add(adapter);
    }

    public void fetchExternalWorks() {
        for (ExternalCatalogAdapter adapter : adapters) {
            works.addAll(adapter.fetchWorks());
        }
    }

    public List<Work> search(SearchCriteria criteria, String searchTerm) {
        return criteria.search(works, searchTerm);
    }

    public void addWork(Work work) {
        works.add(work);
    }
    public void removeWors(Work work) {
        works.remove(work);
    }

    // getters
    public List<Work> getWorks() {
        return works;
    }
}
