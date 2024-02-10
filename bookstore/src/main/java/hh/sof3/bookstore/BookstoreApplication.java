package hh.sof3.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof3.bookstore.domain.Book;
import hh.sof3.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository) {
		return (args) -> {

			// adding some data to Book-DB
			Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, "9781234567890", 20.00);
			Book book2 = new Book("A Farewell to Arms", "Ernest Hemingway", 1929, "1232323-21", 50.25);
			Book book3 = new Book("Animal Farm", "George Orwell", 1945, "2212343-5", 33.33);
			Book book4 = new Book("The Two Towers", "J. R. R. Tolkien", 1954, "936070", 50.50);
		
			bookRepository.save(book1);
			bookRepository.save(book2);
			bookRepository.save(book3);
			bookRepository.save(book4);
		};
	}

}
