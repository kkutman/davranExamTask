package peaksoft;

import peaksoft.classes.Company;
import peaksoft.classes.Product;
import peaksoft.config.HibernateConfig;
import peaksoft.dao.category.CategoryDao;
import peaksoft.dao.category.CategoryDaoImpl;
import peaksoft.dao.company.CompanyDao;
import peaksoft.dao.company.CompanyDaoImpl;
import peaksoft.dao.products.ProductDaoImpl;

import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        CategoryDao categoryDao = new CategoryDaoImpl();
        System.out.println(categoryDao.getAllProductGroupByCategoryName());
    }
}
