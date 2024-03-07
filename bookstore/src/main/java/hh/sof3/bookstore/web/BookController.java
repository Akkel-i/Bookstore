package hh.sof3.bookstore.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.sof3.bookstore.domain.Book;
import hh.sof3.bookstore.domain.BookRepository;
import hh.sof3.bookstore.domain.CategoryRepository;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    // http://localhost:8080/index
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String indexPage() {
        return "index"; // index.html
    }

    // http://localhost:8080/booklist
    @RequestMapping(value = "/booklist", method = RequestMethod.GET)
    public String getBooks(Model model) {

        // luo listan kaikista DB kirjoista
        model.addAttribute("books", bookRepository.findAll());

        return "booklist"; // booklist.html
    }

    // http://localhost:8080/addbook.html
    @RequestMapping(value = "/newbook", method = RequestMethod.GET)
    public String getNewBookForm(Model model) {

        // luo tyhjän Book-olion lomakkeelle
        model.addAttribute("book", new Book());
        // luo listan kaikista kategorioista
        model.addAttribute("categories", categoryRepository.findAll());
        return "addbook"; // addbook.html
    }

    @RequestMapping(value = "/savebook", method = RequestMethod.POST)
    public String saveBook(Book newBook, Model model) {

        // tallentaa uuden Book DB
        bookRepository.save(newBook);
        // palaa endpoint/booklist (GET)
        return "redirect:/booklist";
    }

    // vois tarvita lisää työtä mutta tällä hetkellä poistaa kirjan listalta...
    @RequestMapping(value = "/deletebook/{bookId}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteBook(@PathVariable("bookId") Integer bookId, Model model) {
        System.out.println("Valittu kirja on id: " + bookId);

        // poistaa bookId perusteella
        bookRepository.deleteById(bookId);

        return "redirect:/booklist";
    }

    @RequestMapping(value = "/editbook/{bookId}", method = RequestMethod.GET)
    public String editBookGet(@PathVariable("bookId") Integer bookId, Model model) {

        Optional<Book> bookToEdit = bookRepository.findById(bookId);

        System.out.println("Valittu kirja on id: " + bookId);
        System.out.println(bookRepository.findById(bookId));

        // muokkaa kirjaa
        model.addAttribute("book", bookToEdit);

        return "editbook"; // editbook.html
    }

    @RequestMapping(value = "/editbook", method = RequestMethod.POST)
    public String editBookPost(Book editBook, Model model) {

        // muokkaa kyseistä kirjaa DB
        // Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925,
        // "9781234567890", 20.00);
        // bookRepository.save(book1);

        // tallenna muokattu kirja
        bookRepository.save(editBook);

        // palaa endpoint/booklist (GET)
        return "redirect:/booklist";
    }
}
