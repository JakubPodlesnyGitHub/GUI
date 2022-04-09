package GUI1.Zadanie9;

public class Account {
    double balance;
    static double intrestRate;

    public Account() {
        this.balance = 0;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            this.balance -= amount;
        } else {
            System.out.println("Nie masz tyle kasy");
        }
    }

    public void transfer(Account acc, double amout) {
        if (balance >= amout) {
            this.balance -= amout;
            acc.balance += amout;
        } else {
            System.out.println("Nie masz tyle kasy");
        }

    }

    public static void setInterestRate(double intrest) {
        intrestRate = intrest;
    }

    public void addInterest() {
        this.balance = balance + (balance * (intrestRate / 100));
    }
}
