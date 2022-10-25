package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Hannes Groeller on 10/24/2022.
 */

@Controller
public class BookController {

    // To enhance that model with a list of books, one has to bring in
    // an instance of the book repository.
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // At runtime, when Spring gets a request to the URL /books it is going to
    // execute the getBooks method, and it's going to provide that method a model,
    // a model object, and our code is saying for that model we are going to add
    // the attribute called books, and we're going to get execute book repository
    // which is going to give us a list of books.
    // Now this model is going to get returned back to our view layer, and it's
    // going to have an attribute books and a list of books on that, and then
    // we'll be able to utilize that value inside our view layer to apply the
    // necessary view that we're going to be returning back to the client.
    @RequestMapping("/books")
    public String getBooks(Model model){

        model.addAttribute("books", bookRepository.findAll());

        // Define the view name.  We will configure it in class #22
        // (Thymeleaf Templates).
        return "books";
    }
}
