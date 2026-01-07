import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HSFactory {
	private static SessionFactory factory;

	static {
		Configuration cfg = new Configuration();
		cfg.configure("/hibernate.cfg.xml");
		cfg.addAnnotatedClass(Product.class);
		factory = cfg.buildSessionFactory();
	}

	public static Session getSession() {
		return factory.openSession();
	}
}
