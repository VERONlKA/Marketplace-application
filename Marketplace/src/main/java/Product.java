public interface Product {
    String getName();
    int getPrice();
    int getId();
    void addUser(User user);
    void deleteUser(User user);
    public void displayListOfBuyers();
}
