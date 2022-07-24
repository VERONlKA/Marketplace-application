import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        Marketplace market = new Marketplace();
        String name, lastname;
        int amountOfMoney, id, price;
        List<Product> products = new ArrayList<>();
        List<User> user = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int i = 0;
        int j = 10;
        do{
            System.out.println("Choose option:");
            System.out.println("1. Add user;\n2. Add product;\n3. Display list of users;\n4. Display list of products;\n5. Buy product;\n6. List of user's purchased products;\n7. List of buyers of product;\n8. Delete user;\n9. Delete product;\n10. Exit");
            Scanner sc = new Scanner(System.in);
            try{
                i = sc.nextInt();
            switch (i){
                case 1:
                System.out.print("Input name: ");
                name = scanner.nextLine();
                if(name.isEmpty()){
                    throw new Exception();
                }
                System.out.print("Input lastname: ");
                lastname = scanner.nextLine();
                    if(lastname.trim().isEmpty()){
                        throw new Exception();
                    }
                System.out.print("Input amount of money: ");
                amountOfMoney = sc.nextInt();
                if(amountOfMoney<0){
                    throw new Exception();
                }
                id = market.setIdUser();
                System.out.println("Id: "+ id);
                market.addUser(new UserMarket(name, lastname, amountOfMoney, id, products));
                break;
                case 2:
                    System.out.print("Input name: ");
                    name = scanner.nextLine();
                    if(name.trim().isEmpty()){
                        throw new Exception("name");
                    }
                    System.out.print("Input price: ");
                    price = sc.nextInt();
                    id = market.setIdUser();
                    System.out.println("Id: "+ id);
                    market.addProduct(new ProductMarket(name, price, id, user));
                    break;
                case 3:
                    System.out.println("List of Users:");
                    market.displayListOfUsers();
                    break;
                case 4:
                    System.out.println("List of products:");
                    market.displayListOfProducts();
                    break;
                case 5:
                    System.out.println("Input id: ");
                    id = sc.nextInt();
                    market.buyProduct(market.findByIdUser(id));
                    break;
                case 6:
                    System.out.println("Input id: ");
                    id = sc.nextInt();
                    market.findByIdUser(id).displayListOfProducts();
                    break;
                case 7:
                    System.out.println("Input id: ");
                    id = sc.nextInt();
                    market.findByIdProduct(id).displayListOfBuyers();
                    break;
                case 8:
                    System.out.println("Input id: ");
                    id = sc.nextInt();
                    market.deleteUser(market.findByIdUser(id));
                    System.out.println("Bye ):");
                    break;
                case 9:
                    System.out.println("Input id: ");
                    id = sc.nextInt();
                    market.deleteProduct(market.findByIdProduct(id));
                    System.out.println("Product deleted");
                    break;
                case 10:
                    break;
                default:
                    throw new Exception();

            }}  catch (Exception e) {
                j--;
                System.out.println("You have entered incorrect"+e.getMessage()+", please try again, you have "+j+" tries");
            }

        }while(i!=10 && j>0);
    }
}
