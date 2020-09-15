package cphBusiness.banking;

import java.util.ArrayList;
import java.util.List;

public class BaseAccount {
    private final IBank bank;
    private final ICustomer customer;
    private final String number;
    private long balance = 0;
    private final List<Transaction> transactions = new ArrayList<>();

    public BaseAccount(IBank bank, ICustomer customer, String number){
        this.bank = bank;
        this.customer = customer;
        this.number = number;
    }
    public IBank getBank(){
        return bank;
    }
    public ICustomer getCustomer(){
        return customer;
    }
    public String getNumber(){
        return number;
    }
    public long getBalance(){
        return balance;
    }

    public void transfer(long amount, BaseAccount destination) {
        balance -= amount;
        destination.balance += amount;

        Transaction transaction = new Transaction(this, amount, destination);
        transactions.add(transaction);
        destination.transactions.add(transaction);
    }
    public void transfer(long amount, String destinationNumber){
        transfer(amount, bank.getAccount(destinationNumber));
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
