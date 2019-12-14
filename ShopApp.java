
import java.util.Scanner;

public class ShopApp {

    public static final String POUND = "\u00A3";

    public static void main(String[] args) {

        Product pr1 = new Product(1, "Milk", 10, 1.0);
        Product pr2 = new Product(2, "Sugar", 20, 2.0);
        Product pr3 = new Product(3, "Bread", 30, 3.0);
        Product pr4 = new Product(4, "Cake", 40, 4.0);
        Product pr5 = new Product(5, "Coffee", 50, 5.0);

        Product[] products = new Product[10];
        products[0] = pr1;
        products[1] = pr2;
        products[2] = pr3;
        products[3] = pr4;
        products[4] = pr5;

        System.out.println("= Please, choose from the options below: =");
        System.out.println("[1] Display all products");
        System.out.println("[2] Buy stock");
        System.out.println("[3] Sell stock");
        System.out.println("[4] Reprice an item of stock");
        System.out.println("[5] Display the total value of all stock");

        Scanner sc = new Scanner(System.in);
        String option = sc.nextLine();
        choice(products, Integer.parseInt(option));
    }

    public static void choice(Product[] arr, int n) {
        switch (n) {
            case 1:
                print(arr);
                break;
            case 2:
                System.out.println("Enter the product ID. Current stock:");
                print(arr);
                Scanner sc1 = new Scanner(System.in);
                String str1 = sc1.nextLine();
                int id = Integer.parseInt(str1);

                System.out.println("Enter the amount of items you want to buy");
                Scanner sc2 = new Scanner(System.in);
                String str2 = sc2.nextLine();
                int am = Integer.parseInt(str2);

                buy(arr, id, am);

                break;
            case 3:
                System.out.println("Enter the product ID");
                print(arr);
                Scanner scSell1 = new Scanner(System.in);
                String strSell1 = scSell1.nextLine();
                int idSell = Integer.parseInt(strSell1);

                System.out.println("Enter the amount of items you want to sell");
                Scanner scSell2 = new Scanner(System.in);
                String strSell2 = scSell2.nextLine();
                int amSell = Integer.parseInt(strSell2);

                sell(arr, idSell, amSell);
                break;
            case 4:
                System.out.println("You has been allowed to change product price. Enter the product ID");
                print(arr);
                Scanner scId = new Scanner(System.in);
                String strId = scId.nextLine();
                int id2 = Integer.parseInt(strId);

                System.out.println("Enter the new price of the product...");
                Scanner scNp = new Scanner(System.in);
                String strNp = scNp.nextLine();
                double newPrice = Double.parseDouble(strNp);

                changePrice(arr, id2, newPrice);
                break;
            case 5:
                System.out.println("The total value of all stock: " + totalValue(arr));
                break;
            default:
                System.out.println("Input error!");
        }
    }

    public static void print(Product[] arr) {
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != null) {
                    System.out.println(arr[i].toString());
                }
            }
        }
    }

    public static double totalValue(Product[] arr) {
        double res = 0;
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != null) {
                    res += Math.round((arr[i].getStockLevel() * arr[i].getPrice()) * 100) / 100;
                }
            }
        } else {
            System.out.println("Input error!");
        }
        return res;
    }

    public static void buy(Product[] arr, int id, int amount) {
        double res = 0;
        if (arr != null && id >= 0 && amount > 0) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != null && id == arr[i].getId()) {
                    res = arr[i].buyStock(amount);
                }
            }
            System.out.println("Products worth " + POUND + res + " has been bought");
        } else {
            System.out.println("Input error!");
        }
    }

    public static void sell(Product[] arr, int id, int amount) {
        double res = 0;
        if (arr != null && id >= 0 && amount > 0) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != null && id == arr[i].getId()) {
                    res = arr[i].sell(amount);
                }
            }
            System.out.println("Products worth " + POUND + res + " has been sold");
        } else {
            System.out.println("Input error!");
        }
    }

    public static void changePrice(Product[] arr, int id, double price) {
        int flag = 0;
        if (arr != null && id >= 0 && price >= 0) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != null) {
                    if (id == arr[i].getId()) {
                        arr[i].setPrice(price);
                        flag++;
                        System.out.println("The price of the product [id" + id + "] has been changed");
                    } 
                }
            }
            if (flag == 0) {
                System.out.println("The product [id" + id + "] not found");
            }
        } else {
            System.out.println("Input error!");
        }
    }

}
