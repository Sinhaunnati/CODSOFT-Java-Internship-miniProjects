import java.util.Scanner;
class BankAccount{
    private double balance;
    public BankAccount(double balance){
        this.balance=balance;
    }
    public double getBalance(){
        return balance;
    }
    public void deposit(double amount){
        if(amount>0){
            balance+=amount;
            System.out.println("deposit successful.");

        }
        else{
            System.out.println("Invalid deposit amount.");
        }
    }
    public void withdraw(double amount){
        if(amount>0 && amount<=balance){
            balance-=amount;
            System.out.println("Withdrawal successful");
        }
        else if(balance<amount){
            System.out.println("Insufficient balance.");
        }
        else{
            System.out.println("Invalid withdrawal amount");
        }
    }
}
class Atm{
    private BankAccount account;
    public Atm(BankAccount account){
        this.account=account;
    }
    public void withdraw(double amount){
        account.withdraw(amount);
    }
    public void deposit(double amount){
        account.deposit(amount);
    }
    public void checkBal(){
        System.out.println("Current balance:Rs"+account.getBalance());
    }
    

}

public class AtmInterface{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        BankAccount myAcc=new BankAccount(1000);
        Atm atm=new Atm(myAcc);
        boolean exit=false;
        System.out.println("Welcome to the ATM");
        while(!exit){
            System.out.println("\n------ATM Menu------");
            System.out.println("1.Withdraw");
            System.out.println("2.Deposit");
            System.out.println("3.Check Balance");
            System.out.println("4.Exit");
            System.out.print("5.Choose an Option:");
            int choice=sc.nextInt();
            switch(choice){
                case 1:System.out.println("Enter amount,You want to withdraw:Rs");
                double withdrawAmount=sc.nextDouble();
                atm.withdraw(withdrawAmount);
                break;
                case 2:System.out.println("Enter amount,You want to deposit:Rs");
                double depositAmount=sc.nextDouble();
                atm.deposit(depositAmount);
                break;
                case 3:atm.checkBal();
                break;
                case 4:exit=true;
                System.out.println("Thank you using ATM.Goodbye!");
                default:System.out.println("Invalid option. Please,Try Again.");

            }
        }
        sc.close();

    }
}