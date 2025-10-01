package src.streamspracticequestion;

import java.util.List;
import java.util.Map;

public interface ILibrarySystem {
    void addBook(IBook book, int quantity);

    void removeBook(IBook book, int quantity);

    int calculateTotal();

    Map<String, Integer> categoryTotalPrice();

    List<BookInfo> booksInfo();

    List<CategoryAuthorWithCount> categoryAndAuthorWithCount();
}