import java.util.Objects;

public class Product {
	private int pid;
	private String pname;
	private String category;
	private int price;
	private int quantity;
	

	public Product() {
		super();
	}

	public Product(int pid, String pname, String category, int price, int quantity) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, pid, pname, price, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(category, other.category) && pid == other.pid && Objects.equals(pname, other.pname)
				&& price == other.price && quantity == other.quantity;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", category=" + category + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}

}
