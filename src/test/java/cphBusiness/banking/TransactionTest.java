package cphBusiness.banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TransactionTest {
    private BaseAccount source;
    private BaseAccount target;

    @BeforeEach
    public void setup(){
        IBank bank = new BankMock();
        ICustomer customer = new CustomerMock();
        source = new BaseAccount(bank, customer,"ABC-123");
        target = new BaseAccount(bank,customer,"XYZ-456");
    }
    @Test
    public void testCreateTransaction(){
        long amount = 1_000_00;
        Transaction transaction = new Transaction(source, amount, target);
        assertNotNull(transaction);
    }

    @Test
    public void testCreateTransactionHasSource(){
        long amount = 1_000_00;
        Transaction transaction = new Transaction(source, amount, target);
        assertEquals(source, transaction.getSource());
    }

    @Test
    public void testCreateTransactionHasTarget(){
        long amount = 1_000_00;
        Transaction transaction = new Transaction(source, amount, target);
        assertEquals(target, transaction.getTarget());
    }

    @Test
    public void testCreateTransactionHasAmount(){
        long amount = 1_000_00;
        Transaction transaction = new Transaction(source, amount, target);
        assertEquals(amount, transaction.getAmount());
    }
}
