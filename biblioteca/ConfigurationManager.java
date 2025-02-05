package biblioteca;

// Singleton
public class ConfigurationManager {
    private static ConfigurationManager instance;

    private int studentLoanLimit;
    private int staffLoanLimit;
    private int teacherLoanLimit;
    private double infractionsLimit;
    private double staffInfractionIncrement;
    private BookCategory bookCategory;

    private ConfigurationManager() {
        this.studentLoanLimit = 2;
        this.staffLoanLimit = 5;
        this.teacherLoanLimit = 10;
        this.infractionsLimit = 5;
        this.staffInfractionIncrement = 0.5;
        this.bookCategory = new BookCategory("Categorias");
    }
    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }
    public void displayCategories() {
        this.bookCategory.display(0);
    }

    // getters
    public int getStudentLoanLimit() {return studentLoanLimit;}
    public int getStaffLoanLimit() {return staffLoanLimit;}
    public int getTeacherLoanLimit() {return teacherLoanLimit;}
    public double getInfractionsLimit() {return infractionsLimit;}
    public double getStaffInfractionIncrement() {return staffInfractionIncrement;}
    public BookCategory getBookCategory() {return bookCategory;}

    // setters
    public void setStudentLoanLimit(int studentLoanLimit) {this.studentLoanLimit = studentLoanLimit;}
    public void setStaffLoanLimit(int staffLoanLimit) {this.staffLoanLimit = staffLoanLimit;}
    public void setTeacherLoanLimit(int teacherLoanLimit) {this.teacherLoanLimit = teacherLoanLimit;}
    public void setInfractionsLimit(double infractionsLimit) {this.infractionsLimit = infractionsLimit;}
    public void setStaffInfractionIncrement(double staffInfractionIncrement) {this.staffInfractionIncrement = staffInfractionIncrement;}


}
