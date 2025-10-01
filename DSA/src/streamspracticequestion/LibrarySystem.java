package src.streamspracticequestion;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LibrarySystem implements ILibrarySystem {

    private Map<IBook, Integer> variableBooks;

    @Override
    public void addBook(IBook book, int quantity) {
        variableBooks.put(book, variableBooks.getOrDefault(book, 0) + 1);
    }

    @Override
    public void removeBook(IBook book, int quantity) {
        variableBooks.computeIfPresent(book, (key, value) -> {
            return value - quantity;
        });
        if (variableBooks.get(book) < 1) variableBooks.remove(book);
    }

    @Override
    public int calculateTotal() {
        return variableBooks.entrySet().stream().mapToInt(e -> (e.getKey().getPrice() * e.getValue())).sum();
//        return 0;
    }

    @Override
    public Map<String, Integer> categoryTotalPrice() {
        return variableBooks.
                entrySet().
                stream().
                collect(Collectors.groupingBy(
                        book -> book.getKey().getCategory(),
                        Collectors.summingInt(book -> (int)book.getKey().getPrice() * book.getValue())
                ));
    }

    @Override
    public List<BookInfo> booksInfo() {
        return variableBooks.entrySet().stream().map( (bookMap) -> {
            IBook book = bookMap.getKey();
            return new BookInfo(book.getTitle(),bookMap.getValue(), book.getPrice());
        }).sorted(Comparator.comparing(BookInfo::getTitle).thenComparing(BookInfo::getPrice)).collect(Collectors.toList());
    }

    @Override
    public List<CategoryAuthorWithCount> categoryAndAuthorWithCount() {
        return List.of();
    }
}
