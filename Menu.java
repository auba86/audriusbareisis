package lt.auba.onlinestore.versija1;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);

    //object from LoginForm and CreateNewUser classes to reach their methods
    LoginForm loginForm = new LoginForm();
    CreateNewUser createNewUser = new CreateNewUser();
    ProductsList productsList = new ProductsList();

    //print main menu with login, create new user, stay incognito and exit functions
    public void welcomeMenu() throws IOException {
        System.out.println("Best online store is open 24/7");
        System.out.println("Please, choose your action (from 1 to 4): \n");
        System.out.println("1. Login");
        System.out.println("2. Create new user");
        System.out.println("3. Stay incognito");
        System.out.println("4. Exit online store");

        int menuChoice = scanner.nextInt();

        switch (menuChoice){
            case 1:
                //invoke login form for registered user's
                loginForm.invokeLoginForm();
                break;
            case 2:
                //invoke register form for new user
                createNewUser.newUser();
                break;
            case 3:
                //open menu for customers who stays incognito (they can see just product list)
                menuIncognito();
                break;
            case 4:
                //close all program
                System.out.println("See you next time!");
                break;
            default:
                System.out.println("Online store is not available at the moment. " +
                        "Please, contact us by phone +370-555-67890");
                break;
        }

    }

    //this menu will be shown for registered users
    public void menuWithLogin(String userName) throws IOException{

        System.out.println("Welcome " + userName + ",");
        System.out.println("please, choose your action (from 1 to 2): \n");
        System.out.println("1. Watch product list");
     //   System.out.println("2. Add to cart and buy");
        System.out.println("2. Logout");

        int menuChoice = scanner.nextInt();

        switch (menuChoice){
            case 1:
               productsList.getProductsList();
               boolean askAction = askAction();
               if(askAction){
                  createCart();
               }
               else {
                   menuWithLogin(userName);
               }
                break;
//            case 2:
//                //productsList.createYourOrder();
//                break;
            case 3:
                //logout
                welcomeMenu();
                break;
            default:
                System.out.println("Online store is not available at the moment. " +
                        "Please, contact us by phone +370-555-67890");
                break;
        }

    }

    //method for customer cart
    private void createCart() throws IOException {
        productsList.getProductsList();
        while(true) {
            System.out.println("Write product ID and press ENTER:");
            int productID = scanner.nextInt();
            System.out.println("Enter quantity of chosen product and press ENTER:");
            int productQuantity = scanner.nextInt();

            System.out.println("System is checking if we have enough products for you . . . . . . ");
            break;

//            boolean test = productsList.checkProductList(productID, productQuantity);
//            if(test) {
//                System.out.println("Užsakymas įvykdytas");
//            }
//            else {
//                System.out.println("Įvyko klaida!!!");
//            }
        }

    }


    //method ask customer if he/she wants to buy something
    private boolean askAction() {
        System.out.println("Do you want to buy something? (Y/N)");
        char answer = scanner.next().charAt(0);
        if(answer == 'Y' || answer == 'y')
            return true;
        else
            return false;
    }

    //this menu will be shown for incognito users
    public void menuIncognito() throws IOException{

        //give chance for user to go from this menu to create new user form
        System.out.println("Menu for Incognito users!");
        System.out.println("please, choose your action (from 1 to 3): \n");
        System.out.println("1. Watch product list");
        System.out.println("2. Create your account");
        System.out.println("3. Go to main page");

        int menuChoice = scanner.nextInt();

        switch (menuChoice){
            case 1:
                productsList.getProductsList();
                menuIncognito();
                break;
            case 2:
                //invoke register form for new user
                createNewUser.newUser();
                break;
            case 3:
                //logout
                welcomeMenu();
                break;
            default:
                System.out.println("Online store is not available at the moment. " +
                        "Please, contact us by phone +370-555-67890");
                break;
        }

    }
}
