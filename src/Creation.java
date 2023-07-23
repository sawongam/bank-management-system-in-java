import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Creation {

    void createAccFun() throws IOException {
        int accNo = accNoCreation();
        String[] accLineInfo = getUserInfoFromUser();
        credWrite(accNo,accLineInfo);
        balWrite(accNo);
        userWrite(accNo, accLineInfo);
        System.out.println("\nAccount created successfully!\n");
        System.out.println("Your account number is: " + accNo);
        System.out.println("Your password is: " + accLineInfo[8]+ "\n");
        Main.menu(accNo);
    }

    String[] getUserInfoFromUser() throws IOException {
        String[] accLineInfo = new String[9];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your Name: ");
        String fullName = scanner.nextLine();
        String[] fullNameArr = fullName.split(" ");
        if (fullNameArr.length == 2) {
            accLineInfo[0] = fullNameArr[0];
            accLineInfo[1] = fullNameArr[1];
        } else {
            System.out.println("Please provide both first name and last name.");
            return getUserInfoFromUser();
        }
        accLineInfo[0] = fullNameArr[0];
        accLineInfo[1] = fullNameArr[1];

        System.out.println("Enter your Date of Birth (YYYY-MM-DD): ");
        accLineInfo[2] = scanner.nextLine();
        System.out.println("Enter your Gender: ");
        accLineInfo[3] = scanner.nextLine();
        System.out.println("Enter your Address: ");
        accLineInfo[4] = scanner.nextLine();
        System.out.println("Enter your Phone Number: ");
        accLineInfo[5] = scanner.nextLine();
        System.out.println("Enter your Email: ");
        accLineInfo[6] = scanner.nextLine();
        System.out.println("Enter your Citizenship Number: ");
        accLineInfo[7] = scanner.nextLine();
        System.out.println("Create a Password for your Account: ");
        accLineInfo[8] = scanner.nextLine();
        return accLineInfo;
        }

    int accNoCreation() throws IOException {
        String lastLine = "";
        int accNo;
        File file = new File("db/credentials.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            lastLine = scanner.nextLine();
        }
        if (Objects.equals(lastLine, "")) {
            accNo = 1;
        } else {
            String[] subLine = lastLine.split(" ");
            accNo = Integer.parseInt(subLine[0]);
            accNo++;
        }
        return accNo;
    }

    void credWrite(int accNo, String[] accLineInfo) throws IOException {
        FileWriter writer = new FileWriter("db/credentials.txt", true);
        writer.write("\n" + accNo + " " + accLineInfo[8]);
        writer.close();
    }

    void balWrite(int accNo) throws IOException {
        int initialBal = 69;
        FileWriter writer = new FileWriter("db/balanceDB.txt", true);
        writer.write("\n" + accNo + " " + initialBal);
        writer.close();
    }

    void userWrite(int accNo, String[] accLineInfo) throws IOException {
        FileWriter writer = new FileWriter("db/userDB.txt", true);
        writer.write("\n" + accNo + " ");
        for (int i = 0; i < 8; i++) {
            writer.write(accLineInfo[i] + " ");
        }
        writer.close();
    }


}

