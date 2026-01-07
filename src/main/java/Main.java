import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("Enter action Required:");
			System.out.println("1. Add Product to DB" + "\n" + "2. Find Product" + "\n" + "3. Iterate through Products"
					+ "\n" + "4. Delete Product" + "\n" + "5. Exit");

			int n = sc.nextInt();

			switch (n) {
			case 1:
				SaveProducts1.run();
				break;
			case 2:
				IterateProducts2.run();
				break;
			case 3:
				ListProducts3.run();
				break;
			case 4:
				DeleteProduct4.run();
				break;
			case 5:
				System.exit(0);;
			}
		}
	}
}
