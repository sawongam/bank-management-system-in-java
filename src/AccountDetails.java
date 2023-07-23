import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class AccountDetails {
    void accountDetailsFun(int accNo) throws IOException {
        File file = new File("db/userDB.txt");
        Scanner scanner = new Scanner(file);
        String wholeDetail = "";
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] subLine = line.split(" ");
            if (accNo == Integer.parseInt(subLine[0])) {
                wholeDetail = line;
                break;
            }
        }
        String[] detail = wholeDetail.split(" ");
        System.out.println("Account Details: ");
        System.out.println("┌────────────────────────────────┐");
        System.out.println("  Full Name: "+ detail[1] + " " + detail[2]);
        System.out.println("  Account Number: "+ detail[0]);
        System.out.println("  Gender: "+ detail[4]);
        System.out.println("  Address: "+ detail[5]);
        System.out.println("  Date of Birth: "+ detail[3]);
        System.out.println("  Phone number: "+ detail[6]);
        System.out.println("  Email: "+ detail[7]);
        System.out.println("  Identification: "+ detail[8]);
        System.out.println("└────────────────────────────────┘");

        System.out.println("\n" + "Press Enter key to continue...");
        Scanner scanner1 = new Scanner(System.in);
        scanner1.nextLine();
        Main.menu(accNo);
    }
}
