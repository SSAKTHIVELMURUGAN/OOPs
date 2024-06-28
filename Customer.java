import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerName;
    private String password;
    private String address;
    private double balance;
    private List<String> transactionHistory;

    public Customer(String customerName, String password, String address) {
        this.customerName = customerName;
        this.password = password;
        this.address = address;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    public void addTransaction(String transaction) {
        this.transactionHistory.add(transaction);
    }

    public void displayCustomerInfo() {
        System.out.println("Customer Name: " + customerName);
        // Do not display password for security reasons
        System.out.println("Address: " + address);
        System.out.println("Balance: $" + balance);
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}
