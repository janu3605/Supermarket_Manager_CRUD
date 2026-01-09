import java.util.Objects;

public class Discount {
	private int id;
	private String offer_name;
	private double percentage;

	public Discount() {
		super();
	}

	public Discount(int id, String offer_name, double percentage) {
		super();
		this.id = id;
		this.offer_name = offer_name;
		this.percentage = percentage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOffer_name() {
		return offer_name;
	}

	public void setOffer_name(String offer_name) {
		this.offer_name = offer_name;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, offer_name, percentage);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Discount other = (Discount) obj;
		return id == other.id && Objects.equals(offer_name, other.offer_name)
				&& Double.doubleToLongBits(percentage) == Double.doubleToLongBits(other.percentage);
	}

	@Override
	public String toString() {
		return "Discount [id=" + id + ", offer_name=" + offer_name + ", percentage=" + percentage + "]";
	}

}
