package hh.sof3.bookstore;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;

import hh.sof3.bookstore.web.*;


@SpringBootTest
class BookstoreApplicationTests {

@Autowired
private BookController bookController;
@Autowired
private CategoryController categoryController;

	// 
	@Test
	public void contextLoads() throws Exception {
		assertThat(bookController).isNotNull();
	}



	@Test
	public void categoryControllerTest() throws Exception {
		assertThat(categoryController).isNotNull();
	}
}
