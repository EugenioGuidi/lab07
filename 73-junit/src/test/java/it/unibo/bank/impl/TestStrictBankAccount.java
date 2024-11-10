package it.unibo.bank.impl;

import it.unibo.bank.api.AccountHolder;
import it.unibo.bank.api.BankAccount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import javax.swing.plaf.basic.BasicBorders.MarginBorder;

/**
 * Test class for the {@link StrictBankAccount} class.
 */
class TestStrictBankAccount {

    // Create a new AccountHolder and a StrictBankAccount for it each time tests are executed.
    private AccountHolder mRossi;
    private BankAccount bankAccount;

    private static final int AMOUNT = 100;
    private static final int ACCEPTABLE_MESSAGE_LENGTH = 20;

    /**
     * Prepare the tests.
     */
    @BeforeEach
    public void setUp() {
        this.mRossi = new AccountHolder("Mario", "Rossi", 1);
        this.bankAccount = new StrictBankAccount(mRossi, 0.0);
    }

    /**
     * Test the initial state of the StrictBankAccount.
     */
    @Test
    public void testInitialization() {
        assertEquals(0.0, bankAccount.getBalance());
        assertEquals(0, bankAccount.getTransactionsCount());
        assertEquals("Mario", bankAccount.getAccountHolder().getName());
        assertEquals("Rossi", bankAccount.getAccountHolder().getSurname());
        assertEquals(1, bankAccount.getAccountHolder().getUserID());
    }

    /**
     * Perform a deposit of 100€, compute the management fees, and check that the balance is correctly reduced.
     */
    @Test
    public void testManagementFees() {
        assertEquals(0, bankAccount.getTransactionsCount());
        assertEquals(1, bankAccount.getAccountHolder().getUserID());
        bankAccount.deposit(1, AMOUNT);
        assertEquals(AMOUNT, bankAccount.getBalance());
        bankAccount.chargeManagementFees(1);
        assertEquals(AMOUNT - StrictBankAccount.MANAGEMENT_FEE - bankAccount.getTransactionsCount() 
        - StrictBankAccount.TRANSACTION_FEE, bankAccount.getBalance());
    }

    /**
     * Test that withdrawing a negative amount causes a failure.
     */
    @Test
    public void testNegativeWithdraw() {
        fail("To be implemented");
    }

    /**
     * Test that withdrawing more money than it is in the account is not allowed.
     */
    @Test
    public void testWithdrawingTooMuch() {
        bankAccount.deposit(1, AMOUNT);
        try {
            bankAccount.withdraw(1, AMOUNT * 2);
            Assertions.fail("withdrawing setting the balance below zero was possible, but should have thrown an exception");
        } catch (IllegalArgumentException e) {
            assertEquals(AMOUNT, bankAccount.getBalance());
            assertNotNull(e.getMessage());
            assertFalse(e.getMessage().isBlank());
            assertTrue(e.getMessage().length() >= ACCEPTABLE_MESSAGE_LENGTH);
        }
    }
}
