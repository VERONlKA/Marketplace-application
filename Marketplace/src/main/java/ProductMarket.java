import java.util.ArrayList;
import java.util.List;

public class ProductMarket implements Product {
    String name;
    int price, id;
    private List<User> users;

    public ProductMarket(String name, int price, int id, List<User> users) {
        this.name = name;
        this.price = price;
        this.id = id;
        this.users = new ArrayList<>(users);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void addUser(User user) {
        this.users.add(user);
    }

    @Override
    public void deleteUser(User user) {
        this.users.removeIf(product1 -> product1.equals(user));
    }

    @Override
    public void displayListOfBuyers() {
        for (User user: users) {
            System.out.println(user.getName()+" "+user.getLastname());
        }
    }
}
