import java.util.ArrayList;
import java.util.List;

public class UserMarket implements User {
    String name, lastName;
    int amountOfMoney, id;
    private List<Product> userProducts;

    public UserMarket(String name, String lastName, int amountOfMoney, int id, List<Product> userProducts){
        this.name = name;
        this.lastName = lastName;
        this.amountOfMoney = amountOfMoney;
        this.id = id;
        this.userProducts = new ArrayList<>(userProducts);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getLastname() {
        return this.lastName;
    }

    @Override
    public int getAmountOfMoney() {
        return this.amountOfMoney;
    }

    @Override
    public int setAmountOfMoney(int amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
        return this.amountOfMoney;
    }

    @Override
    public int getId() {
     return this.id;
    }

    @Override
    public void addProduct(Product product) {
        this.userProducts.add(product);
    }

    @Override
    public void deleteProduct(Product product) {
       this.userProducts.removeIf(product1 -> product1.equals(product));
    }

    @Override
    public void displayListOfProducts() {
        System.out.println("List of products:");
        for (Product product: userProducts) {
            System.out.println(product.getName());
        }
    }

}
