package biblioteca;

public class LoanLimitHandler extends AprovationHandler {
    private static final int STUDENT_LOAN_LIMIT = 2;
    private static final int STAFF_LOAN_LIMIT = 5;
    private static final int TEACHER_LOAN_LIMIT = 10;

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
        if (user instanceof StudentUserType) {
            return STUDENT_LOAN_LIMIT;
        } else if (user instanceof StaffUserType) {
            return STAFF_LOAN_LIMIT;
        } else if (user instanceof TeacherUserType) {
            return TEACHER_LOAN_LIMIT;
        }
        throw new IllegalArgumentException("Tipo inválido de usuário" + user.getClass().getSimpleName());
    }

    private boolean rejectRequest() {
        System.out.println("Limite de livros atingido!");
        return false;
    }
}
