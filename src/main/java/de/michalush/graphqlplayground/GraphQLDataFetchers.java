package de.michalush.graphqlplayground;

import de.michalush.graphqlplayground.entity.Author;
import de.michalush.graphqlplayground.entity.Book;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class GraphQLDataFetchers {
    @Resource
    private BookLibrary bookLibrary;


    public DataFetcher<Book> getBookByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            String bookId = dataFetchingEnvironment.getArgument("id");

            return bookLibrary.getBookById(bookId);
        };
    }

    public DataFetcher<Author> getAuthorForBookDataFetcher() {
        return dataFetchingEnvironment -> {
            final Book book = dataFetchingEnvironment.getSource();

            return bookLibrary.getAuthorById(book.getAuthorId());
        };
    }

    public DataFetcher<Author> getAuthorByIdFetcher() {
        return dataFetchingEnvironment -> {
            String authorId = dataFetchingEnvironment.getArgument("id");

            return bookLibrary.getAuthorById(authorId);
        };
    }

    public DataFetcher<List<Book>> getBooksForAuthor() {
        return dataFetchingEnvironment -> {
            Author author = dataFetchingEnvironment.getSource();

            return bookLibrary.getBooksForAuthor(author.getId());
        };
    }
}
