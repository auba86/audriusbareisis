package lt.auba.onlinestore.versija1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LoginForm {
    private static Scanner scanner = new Scanner(System.in);

    public void invokeLoginForm() throws IOException {
        Menu menu = new Menu();
        String filePath = "D:\\SDA_Mokslai\\WorkFiles\\OnlineStore\\" +
                "src\\main\\java\\lt\\auba\\onlinestore\\versija1\\CustomersList.txt";
        //EMAIL dont participate in verify login data method, but still need to use in file reading process
        String EMAIL = "1";
        int counter = 0;
        boolean checkLoop = false;

        System.out.println("Welcome to login form!");

        //you can enter username and password just 3 times
        while(!checkLoop) {
            Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your user name: ");
        String userName = scanner.nextLine();
        System.out.println("Enter your password: ");
        String userPassword = scanner.nextLine();

            if (verifyLogin(userName, userPassword, EMAIL, filePath)) {
                System.out.println("Login successful");
                menu.menuWithLogin(userName);
                checkLoop = true;
            } else {
                System.out.println("Bad user name or password. Please try again");
                counter++;
                    if(counter < 3) {
                        System.out.println("You still have " + (3 - counter) + " chance/-es to enter right data");
                    }
                    else {
                        System.out.println("Please contact with Online store managers. " +
                                "They will help you to restore your personal data");
                        break;
                    }
            }
        }

        //checkUserData() {if userName with Password exist in database }
        //if not correct, suggest repeat userName and password 2 more times.
        //also add functionality "forget your password?"


    }

    //this method verify if logins data have match with database logins data
    public static boolean verifyLogin(String userName, String password, String EMAIL, String filePath) {
        boolean foundMatch = false;
        String tempUsername = "";
        String tempPassword = "";
        String tempEmail = "1";

        try{
            scanner = new Scanner(new File(filePath));
            scanner.useDelimiter("[,\n]");

            while (scanner.hasNext() && !foundMatch) {
                tempUsername = scanner.next();
                tempPassword = scanner.next();
                //always true, but needed for file reading
                tempEmail = EMAIL;

                if(tempUsername.trim().equals(userName.trim()) && tempPassword.trim().equals(password.trim())
                        && tempEmail.trim().equals(EMAIL.trim())){
                    foundMatch = true;
                }
            }
            scanner.close();

        }
        catch (Exception e){
            System.out.println("Attention!!!");
        }
        return foundMatch;
    }

}
