
public class Product {

    private int id; // in order to deal with user input
    private String name;
    private int stockLevel;
    private double price;

    public Product() {
        super();
    }

    public Product(int id, String name, int stockLevel, double price) {
        this.id = id;
        this.name = name;
        this.stockLevel = stockLevel;
        this.price = price;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            System.out.println("Wrong value!");
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStockLevel() {
        return stockLevel;
    }

    public double getPrice() {
        return price;
    }

    public double buyStock(int boughtAmount) {
        if (boughtAmount < 0) {
            System.out.println("Error! The number of items bought can't be negative");
            return 0;
        }
        if (boughtAmount <= stockLevel) {
            stockLevel -= boughtAmount;
            return Math.round((boughtAmount * price) * 100) / 100;
        }
        System.out.println("Warning! The number of items can't be higher "
                + "than the stock level of the product");
        return 0;
    }

    public double sell(int soldAmount) {
        if (soldAmount < 0) {
            System.out.println("Error! The number of items sold can't be negative");
            return 0;
        }
        if (soldAmount <= stockLevel) {
            stockLevel -= soldAmount;
            return Math.round((soldAmount * price) * 100) / 100;
        }
        System.out.println("Warning! Stock level can't be below zero");
        return 0;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name
                + ", stockLevel=" + stockLevel + ", price=" + price + '}';
    }

}
