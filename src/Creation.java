import java.util.Scanner;

public class Creation {
    void createAccFun() {
//        int a = 69, b=36;
//        File file = new File("credentials.txt");
//        FileWriter writer = new FileWriter(file, true);
//        writer.write("\n"+ a+","+ b);
//        writer.close();
    }

    void inputDetails() {
        String[] accLineInfo = new String[0];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your Name: ");
        accLineInfo[0] = scanner.nextLine();
        System.out.println("Enter your Address: ");
        accLineInfo[1] = scanner.nextLine();
        System.out.println("Enter your Phone Number: ");
        int phoneNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter your Email: ");
        String email = scanner.nextLine();
        System.out.println("Enter your Gender: ");
        String gender = scanner.nextLine();
        System.out.println("Enter your Date of Birth(YYYY-MM-DD): ");
        String dob = scanner.nextLine();
    }

    void accNoCreation() {
        //increment last line id
    }

}
