import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CreateAccount {
    static class UserData {
        private String userEmail;
        private String userPhoneNumber;
        private String userLocation;

        public UserData(String userEmail, String userPhoneNumber, String userLocation) {
            this.userEmail = userEmail;
            this.userPhoneNumber = userPhoneNumber;
            this.userLocation = userLocation;
        }
    }
    static void createAccount() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your email: ");
        String userEmail = scanner.nextLine();
        while(!isValidEmail(userEmail)){
            System.out.println("Enter a valid email address");
            userEmail= scanner.nextLine();
        }
        System.out.print("Enter your phone number: ");
        String userPhoneNumber = scanner.nextLine();
        while(userPhoneNumber.length()!=10){
            System.out.println("Please enter a valid phone number");
            userPhoneNumber = scanner.nextLine();
        }

        System.out.print("Enter your location: ");
        String userLocation = scanner.nextLine();

        int accountNumber = generateAccountNumber();

        String folderName = String.valueOf(accountNumber);
        File accountFolder = new File(folderName);
        if (!accountFolder.exists()) {
            accountFolder.mkdirs();
        }

        String fileName = folderName + File.separator + "acc_" + accountNumber + ".json";
        UserData userData = new UserData(userEmail, userPhoneNumber, userLocation);
        Gson gson=new GsonBuilder()
                .setPrettyPrinting().create();
        try (
                FileWriter writer = new FileWriter(fileName)) {
            gson.toJson(userData,writer);
            System.out.println("Account created successfully!");
        } catch (
                IOException e) {
            System.out.println("An error occurred while creating the account.");
            e.printStackTrace();
        }
    }
    private static boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return Pattern.matches(regex, email);
    }
    private static int generateAccountNumber() {
        return (int) (Math.random() * 1000000000);
    }

}
