package peaksoft.classes;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * name : kutman
 **/
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "companys")
@ToString
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "company_name")
    private String companyName;
    private String country;
    @OneToMany(cascade = {CascadeType.ALL},mappedBy = "company")
    private List<Product> products;

    public Company(String companyName, String country) {
        this.companyName = companyName;
        this.country = country;
    }
}
