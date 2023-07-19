import java.io.*;
import java.util.Scanner;

public class Transaction {
    void transactionFun(int accNo) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Receiver's Account Number: ");
        int rAccNo = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Amount: ");
        int tAmount = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Remarks: ");
        String tRemarks = scanner.nextLine();
        System.out.println("\n");
        allTransaction(accNo, rAccNo, tAmount, tRemarks);
    }

    void allTransaction(int accNo, int rAccNo, int tAmount, String tRemarks) throws IOException {
        if (rAccCheck(rAccNo)) {
            //rAcc Validated
            if (sAccBalCheck(accNo, tAmount)) {
                //sBalance ok
                transaction(accNo, rAccNo, tAmount);  //actual transaction
                System.out.println("Transaction Successful!");
                System.out.println("Press any key to continue...");
                Scanner tscanner = new Scanner(System.in);
                tscanner.nextLine();
                Main.menu(accNo);
            } else {
                System.out.println("Insufficient Balance!");
            }
        } else {
            System.out.println("Incorrect Account Number!");
        }
    }

    boolean rAccCheck(int rAccNo) throws FileNotFoundException {
        File file = new File("balanceDB.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] subLine = line.split(" ");
            int a = Integer.parseInt(subLine[0]);
            if (rAccNo == a) return true;
        }
        return false;
    }

    boolean sAccBalCheck(int accNo, int tAmount) throws FileNotFoundException {
        File file = new File("balanceDB.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] subLine = line.split(" ");
            int a = Integer.parseInt(subLine[0]);
            int b = Integer.parseInt(subLine[1]);
            if (accNo == a) {
                if (tAmount <= b) return true;
            }
        }
        return false;
    }

    void transaction(int accNo, int rAccNo, int tAmount) throws IOException {
        File file = new File("balanceDB.txt");
        Scanner scanner = new Scanner(file);
        String newInfo = "";
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] subLine = line.split(" ");
            int a = Integer.parseInt(subLine[0]);
            int b = Integer.parseInt(subLine[1]);
            if (accNo == a) {
                b = b - tAmount;
            } else if (rAccNo == a) {
                b = b + tAmount;
            }
            String newLine = a + " " + b;
            newInfo += newLine + "\n";
        }
        Writer writer = new FileWriter("balanceDB.txt");
        writer.write(newInfo);
        writer.close();
    }


}