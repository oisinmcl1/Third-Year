import java.time.LocalDate;

/*
Oisin Mc Laughlin
22441106
 */

public class Expense {
    private LocalDate expenseDate;
    private String expenseDescription;
    private Category category;
    private Money amount;

    public Expense(LocalDate expenseDate, String expenseDescription) {
        this.expenseDate = expenseDate;
        this.expenseDescription = expenseDescription;
    }

    // Getters and setters for Date
    public LocalDate getExpenseDate() {
        return expenseDate;
    }
    public void setExpenseDate(LocalDate expenseDate) {
        this.expenseDate = expenseDate;
    }

    // Getters and setters for Description
    public String getExpenseDescription() {
        return expenseDescription;
    }
    public void setExpenseDescription(String expenseDescription) {
        this.expenseDescription = expenseDescription;
    }
}
