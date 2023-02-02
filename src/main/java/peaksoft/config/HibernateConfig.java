package peaksoft.config;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import peaksoft.classes.Category;
import peaksoft.classes.Company;
import peaksoft.classes.Product;

import java.util.Properties;

/**
 * name : kutman
 **/
public class HibernateConfig {
    public static EntityManagerFactory getEntity(){
        Properties properties = new Properties();
        properties.setProperty(Environment.DRIVER,"org.postgresql.Driver");
        properties.setProperty(Environment.URL,"jdbc:postgresql://localhost:5432/postgres");
        properties.setProperty(Environment.USER,"postgres");
        properties.setProperty(Environment.PASS,"postgres");

        properties.setProperty(Environment.HBM2DDL_AUTO,"update");
        properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.setProperty(Environment.SHOW_SQL,"true");
        properties.setProperty(Environment.FORMAT_SQL,"true");

        Configuration configuration = new Configuration();
        configuration.setProperties(properties);
        configuration.addAnnotatedClass(Company.class);
        configuration.addAnnotatedClass(Product.class);
        configuration.addAnnotatedClass(Category.class);

        EntityManagerFactory entityManagerFactory = configuration.buildSessionFactory().unwrap(EntityManagerFactory.class);
        return entityManagerFactory;
    }
}
