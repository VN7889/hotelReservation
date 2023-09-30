import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Hotel Reservation System");
        System.out.println("\nMenu:");
        System.out.println("1: Create an Account");
        System.out.println("2: Start Your Reservation");
        System.out.println("3: Cancel Your Reservation");
        System.out.println("4: Display All My Reservations");
        System.out.println("5: Print Total Bill");
        System.out.println("6: Exit");
        System.out.print("Please select an option (1-6): ");
        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
            case 1:
                createAccount();
                break;
            case 2:
                startReservation();
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                System.out.println("Thank you for using the Hotel Reservation System. Goodbye!");
                System.exit(0);
            default:
                System.out.println("Invalid option. Please select a valid option.");
    }
}

    private static void createAccount() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your email: ");
        String userEmail = scanner.nextLine();

        System.out.print("Enter your phone number: ");
        String userPhoneNumber = scanner.nextLine();

        System.out.print("Enter your location: ");
        String userLocation = scanner.nextLine();

        int accountNumber = generateAccountNumber();

        String folderName = "account_" + accountNumber;
        File accountFolder = new File(folderName);
        if (!accountFolder.exists()) {
            accountFolder.mkdirs();
        }

        String fileName = folderName + File.separator + "acc_" + accountNumber + ".txt";
        try (PrintWriter writer = new PrintWriter(fileName)) {
            writer.println("User Email: " + userEmail);
            writer.println("User Phone Number: " + userPhoneNumber);
            writer.println("User Location: " + userLocation);
            System.out.println("Account created successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while creating the account.");
            e.printStackTrace();
        }
    }

    private static void startReservation() {
        System.out.println("Starting a new reservation...");
    }

    private static int generateAccountNumber() {
        return (int) (Math.random() * 10000);
    }
}






