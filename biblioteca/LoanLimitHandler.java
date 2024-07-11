package biblioteca;

public class LoanLimitHandler extends AprovationHandler {
    private ConfigurationManager configs;

    @Override
    public boolean handleRequest(User user, Copy copy) {
        if (user.countOwnedCopies() >= getLoanLimit(user)) {
            return rejectRequest();
        }
        
        if (this.nextHandler != null) {
            return this.nextHandler.handleRequest(user, copy);
        }
        else {
            return true;
        }
    }
    
    private int getLoanLimit(User user) {
        configs = ConfigurationManager.getInstance();
        if (user instanceof StudentUserType) {
            return configs.getStudentLoanLimit();
        } else if (user instanceof StaffUserType) {
            return configs.getStaffLoanLimit();
        } else if (user instanceof TeacherUserType) {
            return configs.getTeacherLoanLimit();
        }
        throw new IllegalArgumentException("Tipo inválido de usuário" + user.getClass().getSimpleName());
    }

    private boolean rejectRequest() {
        System.out.println("Limite de livros atingido!");
        return false;
    }
}
