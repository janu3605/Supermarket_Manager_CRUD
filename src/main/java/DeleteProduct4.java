import org.hibernate.Session;
import org.hibernate.Transaction;

public class DeleteProduct4 {
	public static void run() throws Exception {
		Session s = HSFactory.getSession();
		Transaction t = s.beginTransaction();

		try {
			int i= 18;
			while(i >= 10) {				
				Product p = (Product) s.find(Product.class, i);
				s.remove(p);
				i--;
			}
			t.commit();
			System.out.println("Successfully Deleted");
		} catch (Exception e) {
			System.out.println("Failed");
			e.printStackTrace();
		}
	}
}
