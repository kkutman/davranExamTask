package peaksoft.dao.category;

import peaksoft.classes.Category;
import peaksoft.classes.Product;

import java.util.List;
import java.util.Map;

/**
 * name : kutman
 **/
public interface CategoryDao {
    String saveCategory(Category category);
    Map<Category,List<Product>> getAllProductGroupByCategoryName();
}
