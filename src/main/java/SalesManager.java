import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class SalesManager {
	public static void makeSale(List<String> productNames) {
		Session session = HSFactory.getSession();
		Transaction tx = session.beginTransaction();

		try {

			Sale sale = new Sale();
			sale.setDate(new Date());

			List<Product> soldProducts = new ArrayList<>();
			double finalBill = 0.0;

			for (String pname : productNames) {

				Query<Product> q = session.createQuery("FROM Product p WHERE p.pname = :n", Product.class);
				q.setParameter("n", pname);
				Product p = q.uniqueResult();

				if (p == null) {
					System.out.println("Product Not Found!");
					continue;
				}

				Query<Inventory> iq = session.createQuery("From Inventory i where i.product.pid = :pid",
						Inventory.class);
				iq.setParameter("pid", p.getPid());
				Inventory stock = iq.uniqueResult();

				if (stock != null && stock.getQuantity() > 0) {
					stock.setQuantity(stock.getQuantity() - 1);
					session.merge(stock);

					double itemPrice = p.getPrice();

					if (p.getDiscount() != null) {
						double discountPrice = p.getPrice() * p.getDiscount().getPercentage();
						itemPrice = itemPrice - discountPrice;
						System.out.println("Discount added on : " + p.getPname());
					}

					finalBill += itemPrice;
					soldProducts.add(p);
					System.out.println("Added to cart : " + p.getPname());

				} else {
					System.out.println("Out of Stock" + p.getPname());
				}

				if (!soldProducts.isEmpty()) {
					sale.setProductList(soldProducts);
					sale.setTotalPrice(finalBill);

					session.persist(sale);
					tx.commit();
					System.out.println("Sale Completed , Total Bill Amt: " + finalBill);

				} else {
					System.out.println("Sale Canceled");
				}

			}

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();

		} finally {
			session.close();
		}

	}
}
