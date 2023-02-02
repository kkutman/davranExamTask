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
@Table(name = "categorys")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "category_name")
    private String CategoryName;
    @OneToMany(mappedBy = "category")
    private List<Product>products;

    public Category(String categoryName) {
        CategoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "CategoryName='" + CategoryName + '\'' +
                '}';
    }
}
