import java.time.LocalDate;
import org.joda.money.Money;

/*
Oisin Mc Laughlin
22441106
 */

public class Expense {
    private LocalDate expenseDate;
    private String expenseDescription;
    private Category expenseCategory;
    private Money expenseAmount;

    public Expense(LocalDate expenseDate, String expenseDescription, Category expenseCategory, Money expenseAmount) {
        this.expenseDate = expenseDate;
        this.expenseDescription = expenseDescription;
        this.expenseCategory = expenseCategory;
        this.expenseAmount = expenseAmount;
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

    // Getters and setters for Category
    public Category getExpenseCategory() {
        return expenseCategory;
    }
    public void setExpenseCategory(Category expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    // Getters and setters for Amount
    public Money getExpenseAmount() {
        return expenseAmount;
    }
    public void setExpenseAmount(Money expenseAmount) {
        this.expenseAmount = expenseAmount;
    }
}
