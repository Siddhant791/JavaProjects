package src.equalfunctionality;

import java.util.Locale;
import java.util.Objects;

public class Dog {

    public String name;
    private String breed;

    public Dog(){}

    public Dog(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    protected String getNameUppercase(){
        return name.toUpperCase();
    }

    @Override
    public boolean equals(Object obj){
        if (obj == this) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Dog dog =  (Dog)obj;
        return Objects.equals(name,dog.getName());
    }

    @Override
    public int hashCode(){
        return Objects.hash(name);
    }
}
