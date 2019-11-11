package de.michalush.graphqlplayground;

import de.michalush.graphqlplayground.entity.Author;
import de.michalush.graphqlplayground.entity.Book;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

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

    public DataFetcher<Author> getAuthorDataFetcher() {
        return dataFetchingEnvironment -> {
            final Book book = dataFetchingEnvironment.getSource();

            return bookLibrary.getAuthorByBookId(book.getId());
        };
    }
}
