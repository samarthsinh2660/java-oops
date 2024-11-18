import java.util.Scanner;

public class l7q4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int balance = 0;
        int i = 0;

        do {
            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            i = s.nextInt();

            switch (i) {
                case 1:
                    // Deposit logic
                    System.out.print("Enter deposit amount: Rs ");
                    int amount = s.nextInt();
                    balance = balance + amount;
                    System.out.println("Deposited: Rs " + amount);
                    System.out.println("Current Balance: Rs " + balance);
                    break;

                case 2:
                    // Withdraw logic
                    System.out.print("Enter withdrawal amount: Rs ");
                    int withAmount = s.nextInt();
                    if (withAmount > balance) {
                        System.out.println("Not Sufficient Fund to withdraw Rs " + withAmount);
                    } else {
                        balance -= withAmount;
                        System.out.println("Withdrawn: Rs " + withAmount);
                        System.out.println("Current Balance: Rs " + balance);
                    }
                    break;

                case 3:
                    System.out.println("Thank you for banking with us!");
                    break;

                default:
                    System.out.println("Invalid option! Please choose again.");
                    break;
            }
        } while (i != 3);
    }
}
