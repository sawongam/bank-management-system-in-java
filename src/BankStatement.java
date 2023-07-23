import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class BankStatement {
    void bankStatementFun(int accNo) throws IOException {
        File file = new File("db/Bank Statement/acc_"+accNo+".txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            System.out.println("\n");
            System.out.println("                           | Bank Statement |");
            System.out.println("---------------------------------------------------------------------------");
            System.out.printf("%-21s | %-6s | %-6s | %-7s | %-10s | %-8s%n", "Description", "Type", "Amount", "Remarks", "Date", "Time");
            System.out.println("---------------------------------------------------------------------------");
            while (scanner.hasNextLine()) {
                String trWLine = scanner.nextLine();
                String[] trLine = trWLine.split(" ");
                String description = trLine[0] + " " + trLine[1] + " " + trLine[2];
                String type = trLine[3];
                String amount = "$" + trLine[4];
                String remarks = trLine[5];
                String date = trLine[6];
                String time = trLine[7];
                System.out.printf("%-21s | %-6s | %-6s | %-7s | %-10s | %-8s%n", description, type, amount, remarks, date, time);
            }
            System.out.println("---------------------------------------------------------------------------");
        } catch (FileNotFoundException e) {
            System.out.println("No Transaction found!");
            exit(accNo);
        }
        exit(accNo);
    }

    void exit(int accNo) throws IOException {
        System.out.println("\n" + "Press Enter key to continue...");
        Scanner scanner1 = new Scanner(System.in);
        scanner1.nextLine();
        Main.menu(accNo);
    }
}
