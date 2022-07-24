import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Marketplace implements Market {
    public List<User> users = new ArrayList<>();
    public List<Product> products = new ArrayList<>();
    int id = 1;
    int money;
    @Override
    public void addUser(User user) {
       this.users.add(user);
    }

    @Override
    public int setIdUser() {
        return id++;
    }

    @Override
    public void addProduct(Product product) {
     this.products.add(product);
    }

    @Override
    public void displayListOfUsers() {
        for (User user: users) {
            System.out.println(user.getId()+" "+user.getName()+" "+user.getLastname()+" - "+user.getAmountOfMoney());
        }
    }

    @Override
    public void displayListOfProducts() {
        for (Product product: products) {
            System.out.println(product.getId()+" "+product.getName()+" - "+product.getPrice());
        }
    }

    @Override
    public void buyProduct(User user) {
        System.out.println("Choose what product you want to buy:");
        displayListOfProducts();
        Scanner scan = new Scanner(System.in);
        int idOfProduct = scan.nextInt();
        try {for(Product product: products) {
            if (idOfProduct == product.getId()){
                money = user.getAmountOfMoney();
                money -= product.getPrice();
                if(money<0){
                    System.out.println("You don't have enough money to buy this product");
                    throw new Exception();
                }
                user.setAmountOfMoney(money);
                user.addProduct(product);
                product.addUser(user);

        }}
        System.out.println(user.getName()+" "+user.getLastname()+" - "+user.getAmountOfMoney());
        user.displayListOfProducts();
        System.out.println("Operation is succesful");
        } catch (Exception e) {
            System.out.println("Operation failed");
        }
    }

    @Override
    public User findByIdUser(int id) throws Exception {
        if(users.size()==0){
            throw new Exception();
        }
        for (User user : users) {
            if (id == user.getId()) {
                System.out.println(user.getName()+" "+user.getLastname()+" - "+user.getAmountOfMoney());
                return user;
        }}
        throw new Exception();
    }

    @Override
    public Product findByIdProduct(int id) throws Exception {
        if(products.size()==0){
            throw new Exception();
        }
        for (Product product : products) {
            if (id == product.getId()) {
                System.out.println(product.getName()+" - "+product.getPrice());
                return product;
        }}
        throw new Exception();
    }


    @Override
    public void deleteUser(User user) {
        for(Product product: products){
            product.deleteUser(user);
        }
        this.users.remove(user);

    }

    @Override
    public void deleteProduct(Product product) {
      for (User user: users){
       user.deleteProduct(product);
      }
      this.products.remove(product);
    }
}
