package org.example;

import org.example.exceptions.NegativeBalanceException;

import java.util.Random;
import java.util.Set;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

public class Main {
    public static void main(String[] args) {
        Bank b = new Bank();
        Account a1, a2, a3;

        try {
            a1 = new Account(1234, Money.of(CurrencyUnit.EUR, 1230));
            a2 = new Account(5678, Money.of(CurrencyUnit.EUR, 3346));
            a3 = new Account(2432, Money.of(CurrencyUnit.EUR, 4444));

            b.addAcc(a1);
            b.addAcc(a2);
            b.addAcc(a3);

            b.printAccounts();
        }
        catch (NegativeBalanceException e) {
            e.printStackTrace();
        }

        RandomTransactionGenerator rtg = new RandomTransactionGenerator(b);
        Thread t = new Thread(rtg);

        b.openBank();
        t.start();
    }
}
