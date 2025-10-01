package src.streamspracticequestion;

public interface IBook {
    void setId(int id);
    int getId();
    void setTitle(String title);
    String getTitle();
    void setAuthor(String author);
    String getAuthor();
    void setPrice(int price);
    int getPrice();
    void setCategory(String category);
    String getCategory();
}
