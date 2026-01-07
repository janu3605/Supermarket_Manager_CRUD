import org.hibernate.Session;

public class IterateProducts2 {
	public static void run() {
		Session s = HSFactory.getSession();
		Product p = s.find(Product.class, 2);
		if (p != null) {
			System.out.println(p);
		} else {
			System.out.println("No record Found");
		}
		s.close();
	}
}
