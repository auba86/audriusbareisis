package lt.auba.onlinestore.versija1;

import java.io.IOException;

public class OnlineStoreMain {
    public static void main(String[] args) throws IOException {
        Menu menu = new Menu();
        //link to Menu class method welcomeMenu()
        menu.welcomeMenu();
        System.out.println("Sveikas pasauli");
    }
}
