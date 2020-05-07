package lt.auba.onlinestore.versija1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CreateNewUser {
    Scanner scanner = new Scanner(System.in);

    //enter and check user's data
    public void newUser() throws IOException {
        Menu menu = new Menu();
        //to check if users password was entered by all rules
        boolean isCorrect = false;
        String password = "";
        String userEmail = "";

        System.out.println("Enter your user name: ");
        String userName = scanner.nextLine();
        while(!isCorrect) {
            System.out.println("A password must have at least 10 characters.");
            System.out.println("A password consists of only letters and digits.");
            System.out.println("First password symbol should be capital letter.");
            System.out.println("A password must contain at least two digits.\n");
            System.out.println("Enter your password");
            password = scanner.nextLine();
            isCorrect = checkPassword(password);

            if(isCorrect) {
                System.out.println("Enter your email: ");
                userEmail = scanner.nextLine();
                System.out.println("Thank you! Your data was saved. Now you can go to login page");
            }
            else {
                System.out.println("You entered bad password. Please, read how to create correct password!\n");
            }
        }

        /*
        Saving user's data to database or file
         */
        saveUserData(userName, password, userEmail);
        //invoke welcome menu where customer can login to the system
        menu.welcomeMenu();
    }

    //write new user data to file
    private static void saveUserData(String userName, String password, String userEmail) throws IOException {
        FileWriter fileWriter = new FileWriter("D:\\SDA_Mokslai\\WorkFiles\\OnlineStore\\" +
                "src\\main\\java\\lt\\auba\\onlinestore\\versija1\\CustomersList.txt", true); //Set true for append mode
        PrintWriter printWriter = new PrintWriter(fileWriter);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(userName + "," + password + "," + userEmail);
        printWriter.println(stringBuffer.toString());  //New line
        printWriter.close();
    }

    //here checking if password is correct or not and return true or false
    public boolean checkPassword(String pass){
        char[] newArray = pass.toCharArray();
        int arrayLength = newArray.length;
        int letters = 0;
        int digits = 0;
        int otherSymbols = 0;
        boolean firstLetterCapitalize;

        if (Character.isUpperCase(newArray[0]))
            firstLetterCapitalize = true;
        else
            firstLetterCapitalize = false;

        for(int x = 0; x < newArray.length; x++) {
            if(Character.isLetter(newArray[x])) {
                letters++;
            }
            else if (Character.isDigit(newArray[x])){
                digits++;
            }
            else
                otherSymbols++;
        }

        if((arrayLength >= 10) && (digits >= 2) && (letters >= 1) && (otherSymbols==0) && (firstLetterCapitalize == true))
            return true;
        else
            return false;
    }


    // FUTURE: create method which check if entered correct password is safe or not

}
