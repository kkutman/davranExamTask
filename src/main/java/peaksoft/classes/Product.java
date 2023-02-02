package peaksoft.classes;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

/**
 * name : kutman
 **/
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "products")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product_name")
    private String productName;
    private int price;
    @Column(name = "year_of_issue")
    private LocalDate yearOfIssue;
    @ManyToOne
    private Company company;
    @ManyToOne
    private Category category;

    public Product(String productName, int price, LocalDate yearOfIssue) {
        this.productName = productName;
        this.price = price;
        this.yearOfIssue = yearOfIssue;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", yearOfIssue=" + yearOfIssue +
                ", company=" + company.getCompanyName() +
                ", category=" + category.getCategoryName() +
                "\n";
    }
}
