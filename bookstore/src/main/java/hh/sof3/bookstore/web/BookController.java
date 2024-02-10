package hh.sof3.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hh.sof3.bookstore.domain.Book;
import hh.sof3.bookstore.domain.BookRepository;


@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    // http://localhost:8080/index
    @RequestMapping(value="/index", method=RequestMethod.GET)
    public String indexPage() {
        return "index"; //index.html
    }
    
    // http://localhost:8080/booklist
    @RequestMapping(value = "/booklist", method=RequestMethod.GET)
    public String getBooks(Model model) {

        // luo listan kaikista DB kirjoista
        model.addAttribute("books", bookRepository.findAll());

        return "booklist"; // booklist.html
    }
    
    // http://localhost:8080/addbook.html
    @RequestMapping(value ="/newbook", method = RequestMethod.GET)
    public String getNewBookForm(Model model) {

        // luo tyhjän Book-olion lomakkeelle
        model.addAttribute("book", new Book()); 
        return "addbook"; // addbook.html
    }

    @RequestMapping(value= "/savebook", method = RequestMethod.POST)
    public String saveBook(Book newBook, Model model) {

        // tallentaa uuden Book DB
        bookRepository.save(newBook);
        // palaa endpoint/booklist (GET)
        return "redirect:/booklist"; 
    }

// vois tarvita lisää työtä mutta tällä hetkellä poistaa kirjan listalta...
    @RequestMapping(value = "/deletebook/{bookId}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("bookId") Integer bookId, Model model) {
        System.out.println("Valittu kirja on id: " + bookId);

        // poistaa bookId perusteella
        bookRepository.deleteById(bookId);

        return "redirect:/booklist";
    }

}
