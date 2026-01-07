import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class ListProducts3 {
	public static void run() {
		Session s = HSFactory.getSession();
		Query<Product> q = s.createQuery("From Product", Product.class);

		List<Product> products = q.list();

		for (Product p : products) {
			System.out.println(p);
		}
		s.close();
	}
}
