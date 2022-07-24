public interface Market {
    void addUser(User user);
    int setIdUser();
    void addProduct(Product product);
    void displayListOfUsers();
    void displayListOfProducts();
    void buyProduct(User user ) throws Exception;
    User findByIdUser(int id) throws Exception;
    Product findByIdProduct(int id) throws Exception;
    void deleteUser(User user);
    void deleteProduct(Product product);
}
