import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class ProductManager {

	public static void addProduct(String name, String category, double price) {
		Session session = HSFactory.getSession();
		Transaction tx = session.beginTransaction();

		try {
			Product p = new Product(0, name, category, price);
			Inventory i = new Inventory(0, 0, new Date(), p);
			session.persist(p);
			session.persist(i);

			tx.commit();
			System.out.println("Product Inserted");
		} catch (Exception e) {
			tx.rollback();
			System.out.println("TX Failed");
			e.printStackTrace();
		}
		session.close();
	}

	public static void deleteProduct(String name, String category) {
		Session session = HSFactory.getSession();
		Transaction tx = session.beginTransaction();

		try {
			Query<Product> q = session.createQuery("FROM Product p WHERE p.pname = :n and p.category = :c",
					Product.class);
			q.setParameter("n", name);
			q.setParameter("c", category);

			Product p = q.uniqueResult();

			if (p != null) {
				session.remove(p);
				tx.commit();
				System.out.println("Successfully Deleted");
				session.close();
			} else {
				System.out.println("Product not Found - Deletion Failed");
			}
		} catch (Exception e) {
			tx.rollback();
			System.out.println("Error");
			e.printStackTrace();
		}
	}

	public static void findProduct(String name, String category) {
		Session session = HSFactory.getSession();

		Query<Product> q = session.createQuery("FROM Product p WHERE p.pname = :n and p.category = :c", Product.class);
		q.setParameter("n", name);
		q.setParameter("c", category);

		Product p = q.uniqueResult();

		if (p != null) {
			System.out.println("Found: " + p);
		} else {
			System.out.println("Product not found.");
		}
		session.close();
	}

	public static void listProducts() {
		Session session = HSFactory.getSession();
		Query<Product> q = session.createQuery("From Product", Product.class);

		List<Product> products = q.list();

		for (Product p : products) {
			System.out.println(p);
		}
		session.close();
	}
}
