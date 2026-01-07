import org.hibernate.Session;
import org.hibernate.Transaction;

public class SaveProducts1 {
	public static void run() throws Exception {
		Session session = HSFactory.getSession();
		Transaction tx = session.beginTransaction();

		try {
			Product p1 = new Product(0, "Whole Milk 1L", "Dairy", 60, 20);
			Product p2 = new Product(0, "Brown Bread", "Bakery", 45, 15);
			Product p3 = new Product(0, "Salted Butter", "Dairy", 110, 10);

			Product p4 = new Product(0, "Potato Chips", "Snacks", 20, 50);
			Product p5 = new Product(0, "Coca Cola 500ml", "Beverages", 40, 30);
			Product p6 = new Product(0, "Dark Chocolate", "Snacks", 80, 25);

			Product p7 = new Product(0, "Basmati Rice 1kg", "Grains", 150, 40);
			Product p8 = new Product(0, "Organic Honey", "Essentials", 250, 5);
			Product p9 = new Product(0, "Dish Soap", "Household", 55, 12);

			session.persist(p1);
			session.persist(p2);
			session.persist(p3);
			session.persist(p4);
			session.persist(p5);
			session.persist(p6);
			session.persist(p7);
			session.persist(p8);
			session.persist(p9);

			session.flush();
			tx.commit();
			System.out.print("Products Inserted");

		} catch (Exception e) {
			tx.rollback();
			System.out.println("TX Failed");
			e.printStackTrace();
		}
		session.close();
	}
}
