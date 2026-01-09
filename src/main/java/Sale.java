import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Sale {
	private int sid;
	private Date date;
	private List<Product> productList;
	private double totalPrice;

	public Sale() {
		super();
	}

	public Sale(int sid, Date date, List<Product> productList, double totalPrice) {
		super();
		this.sid = sid;
		this.date = date;
		this.productList = productList;
		this.totalPrice = totalPrice;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, productList, sid, totalPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sale other = (Sale) obj;
		return Objects.equals(date, other.date) && Objects.equals(productList, other.productList) && sid == other.sid
				&& totalPrice == other.totalPrice;
	}

	@Override
	public String toString() {
		return "Sale [sid=" + sid + ", date=" + date + ", productList=" + productList + ", totalPrice=" + totalPrice
				+ "]";
	}

}
