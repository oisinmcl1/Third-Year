import java.time.LocalDate;
import org.joda.money.Money;

/**
 * Represents an expense claim made by an employee.
 * Each expense has a date, description, category, and amount, and can be approved or unapproved.
 *
 * @author Oisin Mc Laughlin
 * 22441106
 */
public class Expense {

    /**
     * The date when the expense was incurred.
     */
    private LocalDate expenseDate;

    /**
     * The description of the expense.
     */
    private String expenseDescription;

    /**
     * The category of the expense (e.g., Travel, Equipment).
     */
    private Category expenseCategory;

    /**
     * The amount of the expense.
     */
    private Money expenseAmount;

    /**
     * Whether the expense has been approved. Default is false.
     */
    private boolean expenseApproved;

    /**
     * Creates a new Expense with the specified details.
     *
     * @param expenseDate The date the expense was incurred
     * @param expenseDescription A description of the expense
     * @param expenseCategory The category of the expense
     * @param expenseAmount The amount of the expense
     */
    public Expense(LocalDate expenseDate, String expenseDescription, Category expenseCategory, Money expenseAmount) {
        this.expenseDate = expenseDate;
        this.expenseDescription = expenseDescription;
        this.expenseCategory = expenseCategory;
        this.expenseAmount = expenseAmount;
        this.expenseApproved = false; // Default to unapproved
    }

    /**
     * Gets the date the expense was incurred.
     *
     * @return The date of the expense
     */
    public LocalDate getExpenseDate() {
        return expenseDate;
    }

    /**
     * Sets the date the expense was incurred.
     *
     * @param expenseDate The new date of the expense
     */
    public void setExpenseDate(LocalDate expenseDate) {
        this.expenseDate = expenseDate;
    }

    /**
     * Gets the description of the expense.
     *
     * @return The description of the expense
     */
    public String getExpenseDescription() {
        return expenseDescription;
    }

    /**
     * Sets the description of the expense.
     *
     * @param expenseDescription The new description of the expense
     */
    public void setExpenseDescription(String expenseDescription) {
        this.expenseDescription = expenseDescription;
    }

    /**
     * Gets whether the expense has been approved.
     *
     * @return true if the expense has been approved, false otherwise
     */
    public boolean getExpenseApproved() {
        return expenseApproved;
    }

    /**
     * Approves the expense.
     */
    public void approve() {
        this.expenseApproved = true;
    }

    /**
     * Gets the category of the expense.
     *
     * @return The category of the expense
     */
    public Category getExpenseCategory() {
        return expenseCategory;
    }

    /**
     * Sets the category of the expense.
     *
     * @param expenseCategory The new category of the expense
     */
    public void setExpenseCategory(Category expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    /**
     * Gets the amount of the expense.
     *
     * @return The amount of the expense
     */
    public Money getExpenseAmount() {
        return expenseAmount;
    }

    /**
     * Sets the amount of the expense.
     *
     * @param expenseAmount The new amount of the expense
     */
    public void setExpenseAmount(Money expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    /**
     * Provides a string representation of the expense in the format:
     * "date: description - category - amount".
     *
     * @return The formatted string representing the expense
     */
    @Override
    public String toString() {
        String str = "";

        str += expenseDate + ": ";
        str += expenseDescription + " - ";
        str += expenseCategory + " - ";
        str += expenseAmount;

        return str;
    }
}
