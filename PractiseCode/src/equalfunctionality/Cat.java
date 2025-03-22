package src.equalfunctionality;

public class Cat extends Dog {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public String getNameUppercase() {
        return name.toUpperCase();
    }

    public String getCatName(){
        return name;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == this) return true;
        if (getClass() != obj.getClass() || obj == null) return false;
        Cat catObject = (Cat)obj;
        return this.name.equals(catObject.getName());
    }
}
