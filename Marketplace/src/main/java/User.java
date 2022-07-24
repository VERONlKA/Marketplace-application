public interface User {
    String getName();
    String getLastname();
    int getAmountOfMoney();
    int setAmountOfMoney(int amountOfMoney);
    int getId();
    void addProduct(Product product);
    void deleteProduct(Product product);
    void displayListOfProducts();
}
