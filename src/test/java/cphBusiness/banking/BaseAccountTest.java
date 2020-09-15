package cphBusiness.banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseAccountTest {
    private IBank bank;
    private ICustomer customer;

    @BeforeEach
    public void setup(){
        bank = new BankMock();
        customer = new CustomerMock();
    }

    @Test
    public void testCreateAccount() throws Exception{
        //Arrange
        String number = "ABC-123";

        //Act
        BaseAccount account = new BaseAccount(bank, customer, number);

        //Assert
        assertNotNull(account);
    }
    @Test
    public void testCreatedAccountHasBank(){
        //Arrange
        String number = "ABC-123";

        //Act
        BaseAccount account = new BaseAccount(bank, customer, number);

        //Assert
        assertEquals(bank, account.getBank());
    }
    @Test
    public void testCreatedAccountHasCustomer(){
        //Arrange
        String number = "ABC-123";

        //Act
        BaseAccount account = new BaseAccount(bank, customer, number);

        //Assert
        assertEquals(customer, account.getCustomer());
    }
    @Test
    public void testCreatedAccountHasNumber(){
        //Arrange
        String number = "ABC-123";

        //Act
        BaseAccount account = new BaseAccount(bank, customer, number);

        //Assert
        assertEquals(number, account.getNumber());
    }
    @Test
    public void testCreatedAccountHasZeroBalance(){
        //Arrange
        String number = "ABC-123";

        //Act
        BaseAccount account = new BaseAccount(bank, customer, number);

        //Assert
        assertEquals(0L, account.getBalance());
    }
    @Test
    public void testCreatedAccountHasEmptyTransactions(){
        //Arrange
        String number = "ABC-123";

        //Act
        BaseAccount account = new BaseAccount(bank, customer, number);

        //Assert
        assertEquals(0, account.getTransactions().size());
    }


}
