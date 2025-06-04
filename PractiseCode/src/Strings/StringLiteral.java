package src.Strings;

public class StringLiteral {
public String input = "Default String";

    public StringLiteral(String input) {
        this.input = input;
    }

    public StringLiteral() {
//        this.input = "";
    }

    //Method to get the string value
    public String getValue() {
        input.toUpperCase();
        return input;
    }
}
