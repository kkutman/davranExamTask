package peaksoft.dao.products;

import peaksoft.classes.Product;

import java.util.List;

/**
 * name : kutman
 **/
public interface ProductDao {
    String saveProduct(Product product,Long companyID,Long categoryID);
    List<Product> findAllProductsByCompanyId(Long id);
    String deleteById(Long id);
}
