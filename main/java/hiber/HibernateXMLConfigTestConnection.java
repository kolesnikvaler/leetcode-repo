package hiber;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateXMLConfigTestConnection {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

    }
}
