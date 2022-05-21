import java.io.IOException;
import java.util.Scanner;

public class CountriesAPISolution {
    static Scanner sc = new Scanner(System.in);
    public static String userInput = null;

// Exercise 1
    public static void main(String[] args) throws IOException {
        System.out.println("Please enter any country code in 3 letters, or exit to quit");
        userInput = sc.nextLine();
        CountriesAPI.getCountryAttributes(userInput);
        }

    public static void chooseAgain() throws IOException {
        System.out.println("Please enter any country code in 3 letters, or exit to quit");
        userInput = sc.nextLine();
        if (!userInput.equals("exit")) {
            CountriesAPI.getCountryAttributes(userInput);
        }else {
            System.exit(0);
        }
    }
    }



