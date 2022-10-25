package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Hannes Groeller on 10/25/22.
 */

// Create Author Controller.
@Controller
public class AuthorController {

    private final AuthorRepository authorRepository;

    // Inject Author Repository via constructor into controller.
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    // Create method to handle request for authors at “/authors”.
    @RequestMapping("/authors")
    public String getAuthors(Model model){

        // Add list of authors to model, and return view “authors/list”.
        model.addAttribute("authors", authorRepository.findAll());

        return "authors/list";
    }
}
