package hiber;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.io.IOException;
import java.util.Properties;

public class HibernatePropertiesConfigTestConnection {
    public static void main(String[] args) throws IOException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();

        Properties properties = new Properties();
        properties.load(loader.getResourceAsStream("hibernate.cfg.xml"));

        SessionFactory sessionFactory = new Configuration()
                .addProperties(properties)
                .buildSessionFactory();


    }

    public static SessionFactory getCustomPropertiesSessionFactory(){
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
        properties.put(Environment.URL, "jdbc:mysql://localhost:3306/supershop");
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "password");

        SessionFactory sessionFactory = new Configuration()
                .setProperties(properties)
                .buildSessionFactory();
        return sessionFactory;
    }
}
