import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to SawOnGam Bank Ltd.");
        intro();
    }

    private static void intro() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type 1: Login");
        System.out.println("Type 2: Create Account");
        int choiceAcc = scanner.nextInt();
        if (choiceAcc == 1) loginAcc();
        else if (choiceAcc == 2) createAcc();
        else {
            System.out.println("Incorrect! Choose a valid option again.");
            intro();
        }
    }

    private static void loginAcc() throws IOException {
        Login loginFun = new Login();
        loginFun.loginFun();
    }

    private static void createAcc() throws IOException {
        Creation creationAccFun = new Creation();
        creationAccFun.createAccFun();
    }

    static void menu(int accNo) throws IOException {
        System.out.println("Menu: ");
        System.out.println("Type 1: Balance Inquiry");
        System.out.println("Type 2: Account Details");
        System.out.println("Type 3: Fund transfer");
        System.out.println("Type 4: Bank Statement");
        System.out.println("Type 5: Account Closure");
        System.out.println("Type 6: Log out");
        System.out.println("Type 7: Exit");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                balInquiry(accNo);
                break;
            case 2:
                accDetails(accNo);
                break;
            case 3:
                fundTransfer(accNo);
                break;
            case 4:
                tranHistory(accNo);
                break;
            case 5:
                accClose(accNo);
                break;
            case 6:
                System.out.println("Logged out successfully!");
                System.out.println("\nWelcome to SawOnGam Bank Ltd.");
                intro();
                break;
            case 7:
                System.exit(0);
            default:
                System.out.println("Incorrect! Choose a valid option again.\n");
                menu(accNo);
        }

    }

    private static void balInquiry(int accNo) throws IOException {
        BalanceInquiry balanceInquiryFun = new BalanceInquiry();
        balanceInquiryFun.balanceInquiryFun(accNo);
    }

    private static void accDetails(int accNo) throws IOException {
        AccountDetails accountDetailsFun = new AccountDetails();
        accountDetailsFun.accountDetailsFun(accNo);
    }

    private static void fundTransfer(int accNo) throws IOException {
        Transaction transactionFun= new Transaction();
        transactionFun.transactionFun(accNo);
    }

    private static void tranHistory(int accNo) throws IOException {
        BankStatement bankStatementFun = new BankStatement();
        bankStatementFun.bankStatementFun(accNo);
    }

    private static void accClose(int accNo) throws IOException {
        Deletion accCloseFun = new Deletion();
        accCloseFun.accCloseFun(accNo,"credentials.txt");
        accCloseFun.delLine(accNo,"userDB.txt");
        accCloseFun.delLine(accNo,"balanceDB.txt");
        System.out.println("\nAccount successfully Deleted.");
    }


}

