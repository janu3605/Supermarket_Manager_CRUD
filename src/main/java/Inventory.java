import java.util.Date;
import java.util.Objects;

public class Inventory {
	private int id;
	private int quantity;
	private Date lastUpDate;

	private Product product;

	public Inventory() {
		super();
	}

	public Inventory(int id, int quantity, Date lastUpDate, Product product) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.lastUpDate = lastUpDate;
		this.product = product;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getLastUpDate() {
		return lastUpDate;
	}

	public void setLastUpDate(Date lastUpDate) {
		this.lastUpDate = lastUpDate;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, lastUpDate, product, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inventory other = (Inventory) obj;
		return id == other.id && Objects.equals(lastUpDate, other.lastUpDate) && Objects.equals(product, other.product)
				&& quantity == other.quantity;
	}

	@Override
	public String toString() {
		return "Inventory [id=" + id + ", quantity=" + quantity + ", lastUpDate=" + lastUpDate + ", product=" + product
				+ "]";
	}

}
