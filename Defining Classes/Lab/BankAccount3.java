public class BankAccount {
    private static int currentId;
    private static double interestRate = 0.02;

    private int id;
    private double balance;

    public BankAccount(){
        this.id = ++currentId;
    }

    public static void setInterest(double interest){
        BankAccount.interestRate = interest;
    }

    public double getInterest(int years){
        return this.balance * years * interestRate;
    }

    public void deposit (double amount){
        this.balance += amount;
    }

    public int getId() {
        return id;
    }

}
