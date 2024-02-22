import java.util.*;
class Task3 {
    public static void main(String[] args) {
        int bal = 50000;
        int withdraw;
        int deposit;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Automated Teller Machine");
            System.out.println("To Withdraw: Choose 1");
            System.out.println("To Deposit: Choose 2");
            System.out.println("To Check Balance: Choose 3");
            System.out.println("To exit : Choose 4");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter Money To Withdraw:");
                    withdraw = sc.nextInt();
                    if (withdraw <= bal) {
                        System.out.println("Pls Collect Your Money=" + withdraw);
                        bal = bal - withdraw;
                    } else {
                        System.out.println("INSUFFICIENT BALANCE");
                    }
                    break;
                case 2:
                    System.out.println("Enter money to Deposit:");
                    deposit = sc.nextInt();
                    bal = bal + deposit;
                    System.out.println("Money Deposited!");
                    break;
                case 3:
                    System.out.println("Balance=" + bal);
                    break;
                case 4:
                    sc.close(); // Close the Scanner object before exiting
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }
}
