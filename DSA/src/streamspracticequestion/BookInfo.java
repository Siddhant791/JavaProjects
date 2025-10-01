package src.streamspracticequestion;

public class BookInfo {
    String title;
    int quantity;
    int price;

    public BookInfo(String title, int quantity, int price) {
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }
    public int getQuantity() {
        return quantity;
    }
    public int getPrice() {
        return price;
    }



}
