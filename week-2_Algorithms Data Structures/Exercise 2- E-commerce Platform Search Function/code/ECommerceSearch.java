
import java.util.*;

public class ECommerceSearch {

    public static Product linearSearch(Product[] products, String targetName) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }


    public static Product binarySearch(Product[] products, String targetName) {
        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int comparison = products[mid].productName.compareToIgnoreCase(targetName);

            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "T-shirt", "Fashion"),
            new Product(3, "Shoes", "Footwear"),
            new Product(4, "Phone", "Electronics"),
            new Product(5, "Watch", "Accessories")
        };

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product name to search: ");
        String searchName = scanner.nextLine();

 
        Product result1 = linearSearch(products, searchName);
        System.out.println("\n[Linear Search] Result: " + (result1 != null ? result1 : "Product Not Found"));


        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));


        Product result2 = binarySearch(products, searchName);
        System.out.println("[Binary Search] Result: " + (result2 != null ? result2 : "Product Not Found"));

        scanner.close();
    }
}
