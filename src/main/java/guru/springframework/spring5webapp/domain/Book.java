package guru.springframework.spring5webapp.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Hannes Groeller on 09/27/2022.
 */

@Entity
public class Book {

    @Id
    // Tell hibernate how it is being generated.
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String isbn;

    @ManyToMany
    // Adding @JoinTable in the Book class, makes Book the owner of the many-to-many
    // relationship and Author is the being owned entity.
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors;

    // ---  Note ---
    // Set<E>: A collection that contains no duplicate elements. More formally,
    // sets contain no pair of elements e1 and e2 such that e1.equals(e2), and
    // at most one null element. As implied by its name, this interface models
    // the mathematical set abstraction.
    // ---

    // ***  Add constructors  ***

    // JPA requires a zero-args constructor.
    public Book() {
    }

    public Book(String title, String isbn, Set<Author> authors) {
        this.title = title;
        this.isbn = isbn;
        this.authors = authors;
    }

    // ***  Add Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
}
