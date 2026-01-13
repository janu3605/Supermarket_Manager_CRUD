import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class InventoryManager {

	public static void addStock(String pname, int quantity) {
		Session session = HSFactory.getSession();
		Transaction tx = session.beginTransaction();

		try {
			Query<Inventory> iq = session.createQuery("From Inventory i where i.product.pname = :pname",
					Inventory.class);
			iq.setParameter("pname", pname);
			Inventory stock = iq.uniqueResult();

			if (stock != null) {
				stock.setQuantity(stock.getQuantity() + quantity);
				session.merge(stock);
				tx.commit();
				System.out.println("Added " + quantity + " to " + pname);
			} else {
				System.out.println("Stock null (Inventory not there for Product yet)");
			}

		} catch (Exception e) {
			tx.rollback();
			System.out.println("Adding resource Failed");
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static void removeStock(String pname, int quantity) {
		Session session = HSFactory.getSession();
		Transaction tx = session.beginTransaction();
		try {
			Query<Inventory> iq = session.createQuery("From Inventory i where i.product.pname = :pname",
					Inventory.class);
			iq.setParameter("pname", pname);
			Inventory stock = iq.uniqueResult();

			if (stock != null) {
				stock.setQuantity(stock.getQuantity() - quantity);
				session.merge(stock);
				tx.commit();
				System.out.println("Removed " + quantity + " from " + pname);
			} else {
				System.out.println("Stock Object doesn't exist for Product ");
			}

		} catch (Exception e) {
			tx.rollback();
			System.out.println("Adding resource Failed");
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static void checkStock(String pname) {
		Session session = HSFactory.getSession();
		Transaction tx = session.beginTransaction();

		try {
			Query<Inventory> iq = session.createQuery("From Inventory i where i.product.pname = :pname",
					Inventory.class);
			iq.setParameter("pname", pname);
			Inventory stock = iq.uniqueResult();

			if (stock != null) {
				int qnty = stock.getQuantity();
				tx.commit();
				System.out.println("Product: " + pname + " Quantity: " + qnty);
			} else {
				System.out.println("Stock null (Inventory not there for Product yet)");
			}

		} catch (Exception e) {
			tx.rollback();
			System.out.println("Error checking Stock");
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static boolean checkStock(Product p, Session session) {

		try {
			Query<Inventory> iq = session.createQuery("From Inventory i where i.product.pname = :pname",
					Inventory.class);
			iq.setParameter("pname", p.getPname());
			Inventory stock = iq.uniqueResult();

			if (stock.getQuantity() > 0)
				return true;
			else
				return false;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
