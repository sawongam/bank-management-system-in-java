import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Login {
    void loginFun() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your Account Number: ");
        int accNo = scanner.nextInt();
        System.out.print("Enter your Password: ");
        String pass = scanner.next();
        loginAuth(accNo, pass);
    }

     void loginAuth(int accNo, String pass) throws IOException {
        File file = new File("db/credentials.txt");
        Scanner scanner = new Scanner(file);
        boolean loginBoo = false;
        boolean incPass = false;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] subLine = line.split(" ");
            if (accNo == Integer.parseInt(subLine[0]) && pass.equals(subLine[1])) {
                loginBoo = true;
                break;
            } else if (accNo == Integer.parseInt(subLine[0])) {
                incPass = true;
            }
        }
        if (loginBoo) {
            System.out.println("Login Successful!!\n");
            Main.menu(accNo);
        } else if (incPass) {
            System.out.println("\nIncorrect Password!");
            System.out.println("Please enter again.\n");
            loginFun();
        } else {
            System.out.println("\nAccount doesn't exists!");
            System.out.println("Please enter again.\n");
            loginFun();
        }
    }


}
