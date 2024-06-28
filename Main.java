import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Customer> customers = new ArrayList<>();
    private static Customer loggedInCustomer = null;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    signUp();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    balanceEnquiry();
                    break;
                case 4:
                    deposit();
                    break;
                case 5:
                    transaction();
                    break;
                case 6:
                    history();
                    break;
                case 7:
                    exit();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Please choose an option:");
        System.out.println("1. Sign Up");
        System.out.println("2. Login");
        System.out.println("3. Balance Enquiry");
        System.out.println("4. Deposit");
        System.out.println("5. Transaction");
        System.out.println("6. History");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void signUp() {
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Confirm password: ");
        String confirmPassword = scanner.nextLine();

        if (!password.equals(confirmPassword)) {
            System.out.println("Passwords do not match. Please try again.");
            return;
        }

        String randomAddress = Address.generateRandomAddress();
        Customer customer = new Customer(customerName, password, randomAddress);
        customers.add(customer);

        customer.displayCustomerInfo();
    }

    private static void login() {
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (Customer customer : customers) {
            if (customer.getCustomerName().equals(customerName) && customer.getPassword().equals(password)) {
                System.out.println("Login successful.");
                loggedInCustomer = customer;
                return;
            }
        }

        System.out.println("Login failed. Please check your credentials.");
    }

    private static void balanceEnquiry() {
        if (loggedInCustomer == null) {
            System.out.println("Please login first.");
            return;
        }

        System.out.println("Your current balance is: $" + loggedInCustomer.getBalance());
    }

    private static void deposit() {
        if (loggedInCustomer == null) {
            System.out.println("Please login first.");
            return;
        }

        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than zero.");
            return;
        }

        loggedInCustomer.setBalance(loggedInCustomer.getBalance() + amount);
        String transactionDetails = String.format("Deposited $%.2f", amount);
        loggedInCustomer.addTransaction(transactionDetails);

        System.out.println("Deposit successful.");
    }

    private static void transaction() {
        if (loggedInCustomer == null) {
            System.out.println("Please login first.");
            return;
        }

        System.out.print("Enter recipient address: ");
        String recipientAddress = scanner.nextLine();

        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        if (!loggedInCustomer.getPassword().equals(password)) {
            System.out.println("Invalid password. Transaction cancelled.");
            return;
        }

        Customer recipient = findCustomerByAddress(recipientAddress);
        if (recipient == null) {
            System.out.println("Recipient not found. Transaction cancelled.");
            return;
        }

        double transactionFee = amount * 0.02;
        double totalAmount = amount + transactionFee;

        System.out.printf("Transaction Details:%n");
        System.out.printf("Recipient: %s%n", recipient.getCustomerName());
        System.out.printf("Amount: $%.2f%n", amount);
        System.out.printf("Transaction Fee: $%.2f%n", transactionFee);
        System.out.printf("Total amount including transaction fees: $%.2f%n", totalAmount);

        System.out.print("Do you want to proceed with the transaction? (yes/Yes): ");
        String confirmation = scanner.nextLine();

        if (!confirmation.equalsIgnoreCase("yes")) {
            System.out.println("Transaction cancelled.");
            return;
        }

        if (loggedInCustomer.getBalance() < totalAmount) {
            System.out.println("Insufficient balance. Transaction cancelled.");
            return;
        }

        loggedInCustomer.setBalance(loggedInCustomer.getBalance() - totalAmount);
        recipient.setBalance(recipient.getBalance() + amount);

        String transactionDetails = String.format("Sent $%.2f to %s (Fee: $%.2f)", amount, recipient.getCustomerName(), transactionFee);
        loggedInCustomer.addTransaction(transactionDetails);

        transactionDetails = String.format("Received $%.2f from %s", amount, loggedInCustomer.getCustomerName());
        recipient.addTransaction(transactionDetails);

        System.out.println("Transaction processing...");
        try {
            Thread.sleep(2000); // Simulate loading time
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Transaction completed.");
    }

    private static void history() {
        if (loggedInCustomer == null) {
            System.out.println("Please login first.");
            return;
        }

        System.out.println("Transaction History:");
        for (String transaction : loggedInCustomer.getTransactionHistory()) {
            System.out.println(transaction);
        }
    }

    private static void exit() {
        System.out.println("Exiting the application.");
        scanner.close();
        System.exit(0);
    }

    private static Customer findCustomerByAddress(String address) {
        for (Customer customer : customers) {
            if (customer.getAddress().equals(address)) {
                return customer;
            }
        }
        return null;
    }
}
