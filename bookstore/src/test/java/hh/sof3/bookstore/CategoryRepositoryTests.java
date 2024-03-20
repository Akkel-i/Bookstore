package hh.sof3.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import hh.sof3.bookstore.domain.*;

@SpringBootTest
public class CategoryRepositoryTests {


@Autowired
private CategoryRepository categoryRepository;

    @Test
    public void findByTitleShouldReturnAuthor() {
        List<Category> categorys = categoryRepository.findByName("Comic");

        assertThat(categorys.get(0).getName()).isEqualTo("Comic");
    }

    @Test
    public void createNewCategory() {
    Category category = new Category("Biblical");
    categoryRepository.save(category);
    assertThat(category.getCategoryId()).isNotNull();
    } 

    @Test
    public void removeCategory() {
        List<Category> categorys = categoryRepository.findByName("Biblical");
        if (!categorys.isEmpty()) { 
            Long theID = categorys.get(0).getCategoryId();

            categoryRepository.deleteById(theID);
        }
        
    }

}

