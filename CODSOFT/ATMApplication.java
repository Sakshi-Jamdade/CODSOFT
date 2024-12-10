import java.util.Scanner;

class BankAccount 
{
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber) 
	{
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public double getBalance() 
	{
        return balance;
    }

    public String deposit(double amount) 
	{
        if (amount > 0) 
		{
            balance += amount;
            return String.format("Deposit successful. Your new balance is $%.2f.", balance);
        } 
		else 
		{
            return "Invalid deposit amount. Please enter a positive number.";
        }
    }

    public String withdraw(double amount) 
	{
        if (amount > 0 && amount <= balance) 
		{
            balance -= amount;
            return String.format("Withdrawal successful. Your new balance is $%.2f.", balance);
        } 
		else if (amount > balance) 
		{
            return "Insufficient balance for the withdrawal.";
        } 
		else 
		{
            return "Invalid withdrawal amount. Please enter a positive number.";
        }
    }
}

class ATM 
{
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) 
	{
        this.bankAccount = bankAccount;
    }

    public void displayMenu() 
	{
        Scanner scanner = new Scanner(System.in);
        int choice;

        do 
		{
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) 
			{
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    System.out.println(bankAccount.withdraw(withdrawAmount));
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    System.out.println(bankAccount.deposit(depositAmount));
                    break;
                case 3:
                    System.out.println("Your current balance is $" + bankAccount.getBalance());
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } 
		while (choice != 4);
        scanner.close();
    }
}

public class ATMApplication 
{
    public static void main(String[] args) 
	{
        BankAccount userAccount = new BankAccount("123456789");
        ATM atm = new ATM(userAccount);
        atm.displayMenu();
    }
}
