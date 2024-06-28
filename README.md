# OOPS Project

This project is an implementation of a basic banking system using Object-Oriented Programming (OOP) concepts in Java. The system allows users to sign up, log in, deposit money, make transactions, check balance, and view transaction history.

## Features
--------

* **Sign Up**: Users can create a new account by providing their name and password. An address is automatically generated for each user.
* **Login**: Users can log in with their name and password.
* **Balance Enquiry**: Users can check their current account balance.
* **Deposit**: Users can deposit money into their account.
* **Transaction**: Users can transfer money to another user's account by specifying the recipient's address. The transaction fee is 2% of the transaction amount.
* **Transaction History**: Users can view their transaction history.
* **Exit**: Users can exit the application.

## Classes and Their Responsibilities
--------------------------------------

* **Main**: Manages the main application flow, including user inputs and menu options.
* **CustomerInput**: Represents a customer with properties like name, password, address, balance, and transaction history. Contains methods to manipulate and display customer data.
* **Address**: Generates a random address for each user during sign up.

## How to Run
--------------

1. **Compile the Java files**:
```shell
javac Main.java CustomerInput.java Address.java
```
1. *Run the main application*:
```
shell
java Main
```

*Example Usage*


*Sign Up*

```
Please choose an option:
1. Sign Up
2. Login
3. Balance Enquiry
4. Deposit
5. Transaction
6. History
7. Exit
Enter your choice: 1
Enter customer name: John
Enter password: john123
Confirm password: john123
Customer Name: John
Password: john123
Address: Y7M8P1Z4X6R5V2B3K8Q6F3W5L7G6N8O3D7A1H
Balance: $0.0
Transaction History: []
```

*Deposit*

```
Please choose an option:
1. Sign Up
2. Login
3. Balance Enquiry
4. Deposit
5. Transaction
6. History
7. Exit
Enter your choice: 4
Enter amount to deposit: 100
Deposit successful.
```

*Transaction*

```
Please choose an option:
1. Sign Up
2. Login
3. Balance Enquiry
4. Deposit
5. Transaction
6. History
7. Exit
Enter your choice: 5
Enter recipient address: Y7M8P1Z4X6R5V2B3K8Q6F3W5L7G6N8O3D7A1H
Enter amount: 50
Enter your password: john123
Transaction Details:
Recipient: John
Amount: $50.00
Transaction Fee: $1.00
Total amount including transaction fees: $51.00
Do you want to proceed with the transaction? (yes/Yes): yes
Transaction processing...
Transaction completed.
```

*Balance Enquiry*

```
Please choose an option:
1. Sign Up
2. Login
3. Balance Enquiry
4. Deposit
5. Transaction
6. History
7. Exit
Enter your choice: 3
Your current balance is: $49.0
```

*History*

```
Please choose an option:
1. Sign Up
2. Login
3. Balance Enquiry
4. Deposit
5. Transaction
6. History
7. Exit
Enter your choice: 6
Transaction History:
Deposited $100.00
Sent $50.00 to John (Fee: $1.00)
Received $50.00 from John
```

*Exit*

```
Please choose an option:
1. Sign Up
2. Login
3. Balance Enquiry
4. Deposit
5. Transaction
6. History
7. Exit
Enter your choice: 7
Exiting the application.
```
```
