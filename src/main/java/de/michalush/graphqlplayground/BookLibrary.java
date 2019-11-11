package de.michalush.graphqlplayground;

import com.google.common.collect.ImmutableMap;
import de.michalush.graphqlplayground.entity.Author;
import de.michalush.graphqlplayground.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Repository
public class BookLibrary {
    private final List<Book> books = Arrays.asList(
            new Book("book-1",
                    "Harry Potter and the Philosopher's Stone",
                    223),
            new Book("book-2",
                    "Moby Dick",
                    635),
            new Book("book-3",
                    "Interview with the vampire",
                    371));

    private final Map<String, String> bookToAuthor = ImmutableMap.of("book-1", "author-1",
            "book-2", "author-2",
            "book-3", "author-3");

    private final List<Author> authors = Arrays.asList(
            new Author("author-1",
                    "Joanne",
                    "Rowling"),
            new Author("author-2",
                    "Herman",
                     "Melville"),
            new Author("author-3",
                    "Anne",
                     "Rice"));

    public Book getBookById(String id) {
        return books.stream().filter(b -> id.equals(b.getId())).findFirst().orElse(null);
    }

    public Author getAuthorByBookId(String id) {
        try {
            final String authorId = bookToAuthor.get(id);

            return authors.stream().filter(a -> authorId.equals(a.getId())).findFirst().orElse(null);
        } catch (Exception e) {
            return null;
        }
    }

}
