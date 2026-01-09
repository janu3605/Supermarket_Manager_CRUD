import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		ProductManager ProductM = new ProductManager();

		while (true) {
			System.out.println();
			System.out.println("Enter action Required:");
			System.out.println("1. Add Product to DB" + "\n" + "2. Find Product" + "\n" + "3. Iterate through Products"
					+ "\n" + "4. Delete Product" + "\n" + "5. Make a Sale" + "\n" + "6. Exit");

			int n = sc.nextInt();
			sc.nextLine();

			switch (n) {
			case 1:
				System.out.println("Enter Name, Category, Price");
				String[] inpt = sc.nextLine().split(" ");
				String name = inpt[0];
				String category = inpt[1];
				double price = Double.parseDouble(inpt[2]);

				ProductM.addProduct(name, category, price);
				break;
			case 2:
				System.out.println("Enter Name, Category");
				String[] inpt1 = sc.nextLine().split(" ");
				String name1 = inpt1[0];
				String category1 = inpt1[1];
				ProductM.findProduct(name1, category1);
				break;
			case 3:
				ProductM.listProducts();
				break;
			case 4:
				System.out.println("Enter Name, Category");
				String[] inpt2 = sc.nextLine().split(" ");
				String name2 = inpt2[0];
				String category2 = inpt2[1];

				ProductM.deleteProduct(name2, category2);
				break;
			case 5:
				System.out.println("========= Sale =========");
				System.out.println("Enter the product names to buy");

				List<String> cart = new ArrayList<>();
				while (true) {
					String item = sc.nextLine();
					if (item.equalsIgnoreCase("done"))
						break;
					if (!item.isEmpty())
						cart.add(item);
				}
				SalesManager.makeSale(cart);

				break;
			case 6:
				System.exit(0);
				break;
			}
		}
	}
}
