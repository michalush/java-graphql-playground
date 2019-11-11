package de.michalush.graphqlplayground;

import de.michalush.graphqlplayground.entity.Author;
import de.michalush.graphqlplayground.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BookLibrary {
    private final List<Book> books = Arrays.asList(
            new Book("book-1",
                    "Harry Potter and the Philosopher's Stone",
                    223, "author-1"),
            new Book("book-2",
                    "Moby Dick",
                    635, "author-2"),
            new Book("book-3",
                    "Interview with the vampire",
                    371, "author-3"),
            new Book("book-4",
                    "Harry Potter and the Cursed Child",
                    543, "author-1"));

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


    public Author getAuthorById(final String authorId) {
        return authors.stream().filter(a -> authorId.equals(a.getId())).findFirst().orElse(null);
    }

    public List<Book> getBooksForAuthor(final String authorId) {
        return books.stream().filter(b -> authorId.equals(b.getAuthorId())).collect(Collectors.toList());
    }
}
