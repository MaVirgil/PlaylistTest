import java.util.Scanner;

public class IO {
    private static Scanner sc = new Scanner(System.in);
    private static String userString;
    private static int userInt;

    public static String getUserString() {
        userString = sc.next();
        userString += sc.nextLine();
        return userString;
    }

    public static int getUserInt(int numOptions) {

        while(true) {

            try {
                userInt = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Please enter a valid number!");
                sc.nextLine();
                continue;
            }

            if (userInt > numOptions || userInt <= 0) {
                System.out.println("Please enter a number between 1 and " + numOptions);
                continue;
            }

            return userInt;
        }
    }

    public static int getUserInt() {

        while(true) {

            try {
                userInt = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Please enter a valid number!");
                sc.nextLine();
                continue;
            }

            return userInt;
        }
    }
}
