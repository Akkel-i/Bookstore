package hh.sof3.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import hh.sof3.bookstore.domain.*;

@SpringBootTest
public class BookRepositoryTests {


@Autowired
private BookRepository bookRepository;

    @Test
    public void findByTitleShouldReturnAuthor() {
        List<Book> books = bookRepository.findByTitle("Vaarallinen Juhannus");

        assertThat(books.get(0).getAuthor()).isEqualTo("Tove Jansson");
    }

    @Test
    public void createNewBook() {
    Book book = new Book("Soturikissat: Rikottu laki 5: Tähdetön Maa", "Erin Hunter", 2024, 
    "9789510502716", 19.30, null);
    bookRepository.save(book);
    assertThat(book.getId()).isNotNull();
    } 

    @Test
    public void removeBook() {
        List<Book> books = bookRepository.findByTitle("Soturikissat: Rikottu laki 5: Tähdetön Maa");
        if (!books.isEmpty()) { 
            Integer theID = books.get(0).getId();

            bookRepository.deleteById(theID);
        }
        
    }

}
