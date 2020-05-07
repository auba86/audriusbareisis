package lt.auba.onlinestore.versija1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ProductsList {
    private static Scanner scanner = new Scanner(System.in);

    private static String filePath = "D:\\SDA_Mokslai\\WorkFiles\\OnlineStore\\src\\main\\java\\lt\\auba\\onlinestore\\versija1\\productsList.txt";

    public void getProductsList() throws IOException {
        int sizeOfList = getSizeOfTheList();
        int counter = 0;


        String[] productID = new String[sizeOfList];
        String[] productName = new String[sizeOfList];
        String[] productPrice = new String[sizeOfList];
        String[] productQuantity = new String[sizeOfList];

        try {
            scanner = new Scanner(new File(filePath));
            scanner.useDelimiter("[,\n]");

            while (scanner.hasNext() && counter < sizeOfList) {
                productID[counter] = scanner.next();
                productName[counter] = scanner.next();
                productPrice[counter] = scanner.next();
                productQuantity[counter] = scanner.next();
                counter++;
            }
            scanner.close();

        } catch (Exception e) {
            System.out.println("Attention!!!");
        }

//        ArrayList<Item> sarasas = new ArrayList<Item>();

//        for (int i = 0; i < sizeOfList; i++){
//            sarasas.addAll(productID[i],productName[i], productPrice[i], productQuantity[i]);
//        }
        System.out.println("List of all products");
        System.out.println("ID\t\tName\t\tPrice\t\tQuantity");
        for (int i = 0; i < sizeOfList; i++) {
            System.out.println(productID[i] + "\t" + productName[i] + " -- price: " + productPrice[i] + " -- quantity: " + productQuantity[i]);
        }
    }

    //check product list (if it is enough required products, method return true and change product list file)
//    public boolean checkProductList(int productIDreq, int productQuantityReq) throws IOException {
//
//        //read product list file
//        int sizeOfList = getSizeOfTheList();
//        int counter = 0;
//
//        String[] productID = new String[sizeOfList];
//        String[] productName = new String[sizeOfList];
//        String[] productPrice = new String[sizeOfList];
//        String[] productQuantity = new String[sizeOfList];
//
//        try {
//            scanner = new Scanner(new File(filePath));
//            scanner.useDelimiter("[,\n]");
//
//            while (scanner.hasNext() && counter < sizeOfList) {
//                productID[counter] = scanner.next();
//                productName[counter] = scanner.next();
//                productPrice[counter] = scanner.next();
//                productQuantity[counter] = scanner.next();
//                counter++;
//            }
//            scanner.close();
//
//        } catch (Exception e) {
//            System.out.println("Attention!!!");
//        }
//
//            if(!productQuantity[productIDreq].equalsIgnoreCase(String.valueOf(productQuantityReq))){
//
//            Charset charset = UTF_8;
//            String content = new String(Files.readAllBytes(Paths.get(filePath)), charset);
//            content = content.replaceAll(productQuantity[productIDreq],Integer.toString((Integer.parseInt(productQuantity[productIDreq]) - productIDreq)));
//            Files.write(Paths.get(filePath), content.getBytes(charset));
//            return true;
//        }
//        else {
//            return false;
//        }
//    }


    //get the size of the products list
    public int getSizeOfTheList(){
        int count = 0;
        try{
            scanner = new Scanner(new File(filePath));
            scanner.useDelimiter("[,\n]");
            while(scanner.hasNextLine())
            {
                count++;
                scanner.nextLine();
            }
            scanner.close();

        }
        catch (Exception e){
            System.out.println("Attention!!!");
        }
        return count;
}

}

