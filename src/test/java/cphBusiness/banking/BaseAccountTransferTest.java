package cphBusiness.banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class BaseAccountTransferTest {
    private BaseAccount source;
    private BaseAccount destination;
    private IBank bank;

    @BeforeEach
    public void setup(){
        bank = new BankMock();
        ICustomer customer = new CustomerMock();
        source = new BaseAccount(bank, customer, "ABC-123");
        destination = new BaseAccount(bank, customer, "XYZ-456");
    }
    @Test
    public void testSourceBalanceIsUpdatedOnTransfer(){
        //Arrange
        long balanceBefore = source.getBalance();
        long amount = 100_00;

        //Act
        source.transfer(amount, destination);

        //Assert
        assertEquals(balanceBefore - amount, source.getBalance());
    }
    @Test
    public void testSourceTransactionListIsUpdatedOnTransfer(){
        //Arrange
        long sizeBefore = source.getTransactions().size();
        long amount = 100_00;

        //Act
        source.transfer(amount, destination);

        //Assert
        assertEquals(sizeBefore + 1, source.getTransactions().size());
    }
    @Test
    public void testDestinationTransactionListIsUpdatedOnTransfer(){
        //Arrange
        long sizeBefore = destination.getTransactions().size();
        long amount = 100_00;

        //Act
        source.transfer(amount, destination);

        //Assert
        assertEquals(sizeBefore + 1, destination.getTransactions().size());
    }
    @Test
    public void testSourceLastTransactionOnTransfer(){
        long amount = 100_00;

        //Act
        source.transfer(amount, destination);
        Transaction last = source.getTransactions().get(source.getTransactions().size() - 1);
        assertEquals(amount, last.getAmount());
        assertEquals(source, last.getSource());
        assertEquals(destination, last.getTarget());
    }
    @Test
    public void testDestinationLastTransactionOnTransfer(){
        long amount = 100_00;
        source.transfer(amount, destination);
        Transaction last = source.getTransactions().get(source.getTransactions().size() - 1);
        assertEquals(amount, last.getAmount());
        assertEquals(source, last.getSource());
        assertEquals(destination, last.getTarget());
    }
    @Test
    public void testDestinationBalanceIsUpdatedOnTransfer(){
        //Arrange
        long balanceBefore = destination.getBalance();
        long amount = 100_00;

        //Act
        source.transfer(amount, destination);

        //Assert
        assertEquals(balanceBefore + amount, destination.getBalance());
    }
    @Test
    public void testSourceBalanceIsUpdateOnTransferByNumber(){
        //Arrange
        long balanceBefore = source.getBalance();
        long amount = 100_00;
        String destinationNumber = "XYZ-456";
        //Act
        source.transfer(amount, destinationNumber);

        //Assert
        assertEquals(balanceBefore - amount, source.getBalance());
    }
    @Test
    public void testDestinationBalanceIsUpdateOnTransferByNumber(){
        //Arrange
        String destinationNumber = "XYZ-456";
        BaseAccount destination = bank.getAccount(destinationNumber);
        long balanceBefore = source.getBalance();
        long amount = 200_00;

        //Act
        source.transfer(amount, destinationNumber);

        //Assert
        assertEquals(balanceBefore - amount, destination.getBalance());
    }
}
