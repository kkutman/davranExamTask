package peaksoft.dao.company;

import jakarta.persistence.EntityManager;
import peaksoft.classes.Company;
import peaksoft.config.HibernateConfig;

/**
 * name : kutman
 **/
public class CompanyDaoImpl implements CompanyDao{
    private final EntityManager entityManager = HibernateConfig.getEntity().createEntityManager();
    @Override
    public String saveCompany(Company company) {
        entityManager.isOpen();
        entityManager.getTransaction().begin();
        entityManager.persist(company);
        entityManager.getTransaction().commit();
        entityManager.close();
        return company.getCompanyName()+ " saved...";
    }

    @Override
    public String deleteById(Long id) {
        entityManager.isOpen();
        entityManager.getTransaction().begin();
        Company company = entityManager.find(Company.class, id);
        entityManager.remove(company);
        entityManager.getTransaction().commit();
        entityManager.close();
        return company.getCompanyName()+" deleted";
    }

    @Override
    public String updateCompany(Long id, Company company) {
        entityManager.isOpen();
        entityManager.getTransaction().begin();
        Company company1 = entityManager.find(Company.class, id);
        company1.setCompanyName(company.getCompanyName());
        company1.setCountry(company.getCountry());
        entityManager.getTransaction().commit();
        entityManager.close();
        return company.getCompanyName();
    }
}
