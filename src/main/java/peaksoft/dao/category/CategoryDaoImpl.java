package peaksoft.dao.category;

import jakarta.persistence.EntityManager;
import peaksoft.classes.Category;
import peaksoft.classes.Product;
import peaksoft.config.HibernateConfig;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * name : kutman
 **/
public class CategoryDaoImpl implements CategoryDao {
    private final EntityManager entityManager = HibernateConfig.getEntity().createEntityManager();

    @Override
    public String saveCategory(Category category) {
        entityManager.isOpen();
        entityManager.getTransaction().begin();
        entityManager.persist(category);
        entityManager.getTransaction().commit();
        entityManager.close();
        return category.getCategoryName() + " saved...";
    }

    @Override
    public Map<Category,List<Product>>getAllProductGroupByCategoryName() {
        entityManager.isOpen();
        entityManager.getTransaction().begin();
        List<Product> selectPFromProductP = entityManager.createQuery("select p from Product p", Product.class).getResultList();
        Map<Category,List<Product>> stringListMap = selectPFromProductP.stream().collect(Collectors.groupingBy(Product::getCategory));
        entityManager.getTransaction().commit();
        entityManager.close();
        return stringListMap;
    }
}
