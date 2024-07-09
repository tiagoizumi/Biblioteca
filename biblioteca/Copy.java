package biblioteca;

public class Copy {
    private String id;
    private Work work;
    private int edition;
    private User borrowedBy;

    public Copy(String id, Work work, int edition){
        this.id = id;
        this.work = work;
        this.edition = edition;
        this.borrowedBy = null;
        work.addCopy(this);
    }

    public boolean isAvailable() {
        return borrowedBy == null;
    }

    public boolean returnBook(User user) {
        if (borrowedBy == user){
            borrowedBy = null;
            return true;
        }
        else {
            System.out.println(work.getTitle() + " do id " + id + " não está alugado por " + user.getName());
            return false;
        }
    }

    public String getId() {return id;}
    public Work getWork() {return work;}
    public int getEdition() {return edition;}
    public User getborrowedBy() {return borrowedBy;}

    public String getTitle() {return work.getTitle();}
}
