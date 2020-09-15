package cphBusiness.banking;

public class BankMock implements IBank {
    private BaseAccount account = new BaseAccount(this, new CustomerMock(), "XYZ");
    @Override
    public BaseAccount getAccount(String number) {
        return account;
    }
}
