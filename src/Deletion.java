import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Deletion {

    void accCloseFun(int accNo, String fileName) throws IOException {
        System.out.println("Are you sure want to delete your account?");
        System.out.println("Type 1: Yes");
        System.out.println("Type 2: No");
        Scanner tscanner = new Scanner(System.in);
        int conf = tscanner.nextInt();
        if (conf ==2) {
            Main.menu(accNo);
        } else if (conf != 1) {
            System.out.println("Incorrect! Choose a valid option again.\n");
            accCloseFun(accNo, fileName);
        }
        delLine(accNo, fileName);
    }
    void delLine(int accNo, String fileName) throws IOException {

        File file = new File(fileName);
        String newInfo = "";
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] subLine = line.split(" ");
            int countLine = subLine.length;
            if (accNo == Integer.parseInt(subLine[0])) {
                continue;
            }
            String newLine = "";
            for (int x=0;x < countLine; x++){
                newLine += subLine[x] + " ";
            }
            newInfo += newLine.trim() + "\n";

        }

        // Check if the last line is blank
        if (newInfo.endsWith("\n")) {
            // Remove the newline character
            newInfo = newInfo.substring(0, newInfo.length() - 1);
        }

        FileWriter writer = new FileWriter(fileName);
        writer.write(newInfo);
        writer.close();
        scanner.close();

    }

}
