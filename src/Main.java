import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Hotel Reservation System");
        System.out.println("\nMenu:");
        System.out.println("1: Create an Account");
        System.out.println("2: Start Your Reservation");
        System.out.println("3: Cancel Your Reservation");
        System.out.println("4: Display All My Reservations");
        System.out.println("5: Print Total Bill");
        System.out.println("6: Exit");
        System.out.print("Please select an option (1-6): ");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
            case 1:
                CreateAccount ca =new CreateAccount();
                ca.createAccount();
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
                break;
            default:
                System.out.println("Invalid option. Please select a valid option.");
    }
}
    private static void startReservation() {
        System.out.println("Starting a new reservation...");
    }

}






