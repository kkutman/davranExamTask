package peaksoft.dao.products;

import jakarta.persistence.EntityManager;
import peaksoft.classes.Category;
import peaksoft.classes.Company;
import peaksoft.classes.Product;
import peaksoft.config.HibernateConfig;

import java.util.List;

/**
 * name : kutman
 **/
public class ProductDaoImpl implements ProductDao{
    private final EntityManager entityManager = HibernateConfig.getEntity().createEntityManager();
    @Override
    public String saveProduct(Product product,Long companyID,Long categoryID) {
        entityManager.isOpen();
        entityManager.getTransaction().begin();
        Company company = entityManager.find(Company.class, companyID);
        Category category = entityManager.find(Category.class, categoryID);
        company.setProducts(List.of(product));
        category.setProducts(List.of(product));
        product.setCategory(category);
        product.setCompany(company);
        entityManager.persist(product);
        entityManager.getTransaction().commit();
        entityManager.close();
        return product.getProductName()+ "saved...";
    }

    @Override
    public List<Product> findAllProductsByCompanyId(Long id) {
        entityManager.isOpen();
        entityManager.getTransaction().begin();

        List<Product> products = entityManager.createQuery("select p from Product p join" +
                        " Company c on p.company.id = c.id where c.id = :id",Product.class)
                        .setParameter("id",id).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return products;
    }

    @Override
    public String deleteById(Long id) {
        entityManager.isOpen();
        entityManager.getTransaction().begin();
        Product product = entityManager.find(Product.class, id);
        entityManager.remove(product);
        entityManager.getTransaction().commit();
        entityManager.close();
        return product.getProductName()+" deleted...";
    }
}
