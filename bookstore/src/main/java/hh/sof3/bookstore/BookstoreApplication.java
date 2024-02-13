package hh.sof3.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof3.bookstore.domain.Book;
import hh.sof3.bookstore.domain.BookRepository;
import hh.sof3.bookstore.domain.Category;
import hh.sof3.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {

			// luodaan kategoriat
			Category category1 = new Category("Scifi");
			categoryRepository.save(category1);
			Category category2 = new Category("Comic");
			categoryRepository.save(category2);
			Category category3 = new Category("Fantasy");
			categoryRepository.save(category3);
			Category category4 = new Category("Documentary");
			categoryRepository.save(category4);
			Category category5 = new Category("Novel");
			categoryRepository.save(category5);

			// adding some data to Book-DB
			Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, "9781234567890", 20.00, category5);
			Book book2 = new Book("A Farewell to Arms", "Ernest Hemingway", 1929, "1232323-21", 50.25, category4);
			Book book3 = new Book("Animal Farm", "George Orwell", 1945, "2212343-5", 33.33, category3);
			Book book4 = new Book("The Two Towers", "J. R. R. Tolkien", 1954, "936070", 50.50, category2);
			Book book5 = new Book("Vaarallinen Juhannus", "Tove Jansson", 1954, "951-0-19580-4", 10.50, null);
		
			bookRepository.save(book1);
			bookRepository.save(book2);
			bookRepository.save(book3);
			bookRepository.save(book4);
			bookRepository.save(book5);
		};
	}

}
