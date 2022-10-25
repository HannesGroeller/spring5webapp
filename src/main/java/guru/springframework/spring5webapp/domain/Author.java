package guru.springframework.spring5webapp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by Hannes Groeller on 09/27/2022.
 */

@Entity
public class Author {

    @Id
    // Tell hibernate how it is being generated.
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "authors")
    // private Set<Book> books;
    // Need to set to 'new HashSet<>()' because we took 'book' out of the constructor.
    private Set<Book> books = new HashSet<>();

    // ***  Add constructors  ***

    // JPA requires a zero-args constructor.
    public Author() {
    }

    // public Author(String firstName, String lastName, Set<Book> books) {
    //     this.firstName = firstName;
    //     this.lastName = lastName;
    //     this.books = books;
    // }
    // Get rid of the 'books' for now ... .
    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // ***  Add Getters and Setters  ***

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                // Delete the line, to avoid an infinite loop (circular reference),
                // after we added a Thymeleaf template.
                // ", books=" + books +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        return Objects.equals(id, author.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
