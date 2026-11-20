import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int pin;
        int tryTimes=0;
        do{
            System.out.print("Enter PIN "+(tryTimes+1)+"'st time: \n");
            pin=input.nextInt();

            if(pin == 1234) {
                System.out.print("Correct PIN\n");
                double balance = 2500.75;
                boolean running = true;
                int choice;
                int successfulDeposit=0;
                int successfulWithdraw=0;
                while (running) {
                    System.out.println("\n1. Check Balance");
                    System.out.println("2. Deposit");
                    System.out.println("3. Withdraw");
                    System.out.println("4. Customer Status");
                    System.out.println("5. Exit");
                    choice = input.nextInt();

                    switch (choice) {
                        case 1 -> System.out.print(balance);
                        case 2 -> {
                            System.out.print("Enter Deposit please \n");
                            double deposit = input.nextDouble();
                            if (deposit == 0) {
                                System.out.print("Transaction cancelled.");
                            } else if (deposit < 0) {
                                System.out.print("Invalid amount.");
                            } else {
                                balance += deposit;
                                System.out.print("Current Balance is: "+ balance);
                                successfulDeposit++;
                            }

                        }
                        case 3 -> {
                            System.out.print("Enter Withdraw please \n");
                            double withdrawAmount = input.nextDouble();
                            if (withdrawAmount == 0) {
                                System.out.print("Transaction cancelled.");
                            } else if (withdrawAmount < 0) {
                                System.out.print("Invalid amount.");
                            } else if (withdrawAmount > balance) {
                                System.out.print("amount exceed the balance.");
                            } else {
                                balance -= withdrawAmount;
                                System.out.print("Current Balance is: "+ balance);
                                successfulWithdraw++;
                            }

                        }
                        case 4 -> {
                            if (balance >= 5000) {
                                System.out.print("VIP Customer");
                            } else if (balance >= 1000 && balance < 5000) {
                                System.out.print("Regular Customer");
                            } else {
                                System.out.print("Low Balance");
                            }
                        }
                        case 5 -> {
                            if( successfulWithdraw>0){
                                System.out.print("\nsuccessful Withdraw count is: "+ successfulWithdraw);
                            }
                            if( successfulDeposit>0){
                                System.out.print("\nsuccessful Deposit count is: "+ successfulDeposit);
                            }
                            System.out.print("\nCurrent Balance is: "+ balance);
                            System.out.print("\nThank you for using our ATM.");

                            running = false;

                        }
                        default -> System.out.print("Invalid Menu Choice");


                    }
                    if(balance==0){
                        System.out.print("Warning: Your account is empty.");
                    }


                }
                break;

            }
            else if(pin != 1234 && tryTimes == 2){
                System.out.print("Your account has been locked.");
            }
            tryTimes++;

        } while(tryTimes<3);
    }
}