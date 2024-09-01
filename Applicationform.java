class Applicationform {
    private String name;
    private int rollno;

    public void display() {
        System.out.printf("Name: %s%n", name); 
        System.out.printf("Roll Number: %d%n", rollno); 
    }
    

    public void setValues(String str, int num){
        name= str;
        rollno = num; 
    }

    public String getName(){
        return name;
    }

    public String setName(String changeName){
        name = changeName;
        return name;
    }
}

class Main {
    public static void main(String[] args) {
        Applicationform sakthi = new Applicationform();
        System.out.println("Student details 1");
        sakthi.setValues("Sakthivel Murugan", 23);
        sakthi.display();

        Applicationform vel = new Applicationform();
        System.out.println("Student details 2");
        vel.setValues("Vel", 23);
        vel.display();

        vel.setName("Vel Murugan");
        System.out.println("Changed Name");
        vel.display();
 
    }
}


// Constructor example
class Constructor{

    int mark;
    int rno;
    Constructor(){
        System.out.println("This is default constructor");
        mark = 50;
        rno=23;
    }

    Constructor(int num,int r){
        System.out.println("This is parameterized constructor");
        mark = num;
        rno = r;
    }
    public static void main(String[] args) {
        Constructor obj = new Constructor();
        System.out.println("default constructor: "+obj.mark + " " + obj.rno);
        Constructor obj2 = new Constructor(90, 13);
        System.out.println("Parameterized constructor: " + obj2.mark + " " + obj2.rno);

      }
}


// Polymorphism & Inheritance
class Bank { // Parent class
    int accountNo;
    String accountholderName;
    String branch;
    float balance;

    public int AccountNo(int num) {
        accountNo = num;
        return accountNo;
    }

    public String AccountHolderName(String name) {
        accountholderName = name;
        return accountholderName;
    }

    public String branchName(String name) {
        branch = name;
        return branch;
    }

    public float Balance(float b) {
        balance = b;
        return balance;
    }

    public void offer() {
        System.out.println("No offer");
    }
}

class SBI extends Bank { //hierachy 1
    String interest = "Savings account 7%";

    public void offer(String offerName, int rate) { // Method overloading
        System.out.println("Savings account offer for senior citizens: " + offerName);
        System.out.println("Rate of interest: " + rate + "%");
    }
}

class IOB extends Bank {  //hierachy2
    String interest = "Savings account 5%";

    public void offer(String offerName, int rate, int year) {
        System.out.println("Savings account offer for senior citizens: " + offerName);
        System.out.println("Rate of interest: " + rate + "%");
        System.out.println("Number of years: " + year);
    }
}

class punjab extends IOB{   //multi level inheritance1
    String interest = "SAvings account 9%";
}

class union extends punjab{  //mutli level inheritance2
    String interest = "Savings account 10%";
}

//hybrid multilevel + hierachy ----> [Bank] 1. SBI 2.IOB (hierachy) | [IOB] 1. kotak(multi-level)
class kotak extends IOB{
    String interest = "Savings account 7.9% interest and same for fixed deposit get 0 minimum balance account";
}
class BankMainCall {
    public static void main(String[] args) {
        SBI sbiObj = new SBI();
        System.out.println("SBI Details:");
        System.out.println("Interest: " + sbiObj.interest);
        System.out.println("Account No: " + sbiObj.AccountNo(34645));
        System.out.println("Account Holder Name: " + sbiObj.AccountHolderName("Sakthi"));
        System.out.println("Balance: " + sbiObj.Balance(1321.57f));
        System.out.println("Branch Name: " + sbiObj.branchName("Ambai SBI"));
        sbiObj.offer("Senior Citizen", 8);
        System.out.println();

        IOB iobObj = new IOB();
        System.out.println("IOB Details:");
        System.out.println("Interest: " + iobObj.interest);
        System.out.println("Account No: " + iobObj.AccountNo(598645));
        System.out.println("Account Holder Name: " + iobObj.AccountHolderName("Sakthi Vel"));
        System.out.println("Balance: " + iobObj.Balance(1324965.57f));
        System.out.println("Branch Name: " + iobObj.branchName("Ambasamudram IOB"));
        iobObj.offer("Senior and Grand Master Retirement Plan", 8, 10);
        System.out.println();

        union multilevelinheritance = new union();
        System.out.println("multilevelinheritance "+multilevelinheritance.interest);

        kotak hybrid = new kotak();
        System.out.println(hybrid.interest);

    }
}


//Abstraction class and methods
abstract class IOBBank{
    abstract int accountNo(int num);   //abstract method
    abstract String accountName(String name);
    void offer(){
        System.out.println("Savings account interest 5%");
    }
}

class account1 extends IOBBank{
    int accountNo(int num){
        return num;
    }
    String accountName(String name){
        return name;
    }
}

class BankCall{
    public static void main(String[] args) {
        account1 obj = new account1();
        obj.offer();
        String name = obj.accountName("sakthivel ambai");
        System.out.println("Account name "+name);
        int num = obj.accountNo(1234556);
        System.out.println("Account number "+num);
    }
}

//interface
interface banking{
    abstract int accountNo(int n);
    abstract String branch(String str);
}

class axis implements banking{
    public int accountNo(int n){     //here we need to must put the public otherwise the complier will clashes to each other so to avoid this we must use it
        n = 1234566;
        return n;
    }

    public String branch(String str){
        str = "ambai";
        return str;
    }
}

class Bankingcall{
    public static void main(String[] args) {
        axis axisbank = new axis();
        String name = axisbank.branch(null);
        int num = axisbank.accountNo(0);
        System.out.println(name);
        System.out.println(num);
    }
}


//multiple inheritance
interface father{
    abstract void call();
    abstract void talk();
}

interface mom{
    abstract void call();
    abstract void talk();
}

class Son implements mom,father{
    public void call(){
        System.out.println("I am calling");
    }
    public void talk(){
        System.out.println("I am talking");
    }

}

class Rum{
    public static void main(String[] args) {
        Son obj = new Son();
        obj.call();
        obj.talk();
    }
}