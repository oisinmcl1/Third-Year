import org.example.Account;
import org.example.Bank;
import org.example.Transaction;
import org.example.exceptions.NegativeBalanceException;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Oisin Mc Laughlin
 * 22441106
 */

public class BankTest {
    /**
     * Just first test to see if you can create Bank obj
     *
     * @asserts Bank obj is not null
     */
    @Test
     void testBankNotNull() {
        Bank b = new Bank();
        assertNotNull(b);
    }

    /**
     * Test to see if you can add an account to the bank using addAcc
     * Also tests if you can get an account by its account number using getAccById
     *
     * @throws NegativeBalanceException if the initial balance is negative
     * @asserts Account is added to bank
     */
    @Test
    void testAddAcc() throws NegativeBalanceException {
        Bank b = new Bank();
        Account a = new Account(
                420,
                Money.of(
                        CurrencyUnit.EUR,
                        99
                )
        );

        b.addAcc(a);
        assertEquals(a, b.getAccById(420));
    }

    /**
     * Test to see if you can submit a transaction to the bank using submitTransaction
     *
     * @asserts Transaction is added to transactions queue
     */
    /*
    @Test
    void testSubmitTransaction() throws NegativeBalanceException {
        Bank b = new Bank();
        Account a = new Account(
                420,
                Money.of(
                        CurrencyUnit.EUR,
                        1000000000
                )
        );

        b.submitTransaction(new Transaction(420, 100));
        assertEquals()
    }
     */

    /**
     * Test to see if you can print the accounts details using printAccounts
     *
     * @asserts Accounts details are printed
     */
    /*
    @Test
    void testPrintAccounts() throws NegativeBalanceException {
        Bank b = new Bank();
        Account a1 = new Account(
                420,
                Money.of(
                        CurrencyUnit.EUR,
                        99
                )
        );
        Account a2 = new Account(
                421,
                Money.of(
                        CurrencyUnit.EUR,
                        98
                )
        );

        b.addAcc(a1);
        b.addAcc(a2);
        b.printAccounts();

        String expected = "" +
                "Account 420 has a balance of EUR 99.00\n" +
                "Account 421 has a balance of EUR 98.00";

        assertEquals(expected, b.printAccounts().toString());
    }
     */
}
