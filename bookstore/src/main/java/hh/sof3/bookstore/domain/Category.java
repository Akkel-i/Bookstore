package hh.sof3.bookstore.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {

    // atribuuti
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long categoryId;
    private String name;

    // Relaatio
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "")
    private List<Book> books;

    public Category() {
    };

    public Category(String name) {
        super();
        this.name = name;
    }

    // getter
    public Long getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    // setter
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public void setName(String name) {
        this.name = name;
    }

/*     // tostring
    @Override
    public String toString() {
        return "Category [categoryId=" + categoryId + ", name=" + name + "]";
    } */
}
