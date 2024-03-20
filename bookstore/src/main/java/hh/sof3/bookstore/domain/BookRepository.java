package hh.sof3.bookstore.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface BookRepository extends CrudRepository<Book, Integer> {
    List<Book> findByTitle(String title);


}
