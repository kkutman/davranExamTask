package peaksoft.dao.company;

import peaksoft.classes.Company;

/**
 * name : kutman
 **/
public interface CompanyDao {
    String saveCompany(Company company);
    String deleteById(Long id);
    String updateCompany(Long id,Company company);
}
