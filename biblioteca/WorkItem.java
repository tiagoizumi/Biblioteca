package biblioteca;

public class WorkItem extends Item {
    private Work work;

    public WorkItem(Work work) {
        this.work = work;
    }

    @Override
    public void display(int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print(" ");
        }
        System.out.println(work.getTitle());
    }

    public String getTitle() {
        return work.getTitle();
    }

}
