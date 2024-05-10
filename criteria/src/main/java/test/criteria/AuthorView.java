package test.criteria;

import java.util.List;

@EntityView(Author.class)
public interface AuthorView {

    @IdMapping
    Long getAuthorId();

    String getFirstName();

    String getLastName();

    String getTelephone();

    String getMail();

    List<BookView> getBooks();

    @EntityView(Books.class)
    interface BookView {
        // define the properties you need from the Book entity
    }
}
