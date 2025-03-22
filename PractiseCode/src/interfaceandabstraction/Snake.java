package src.interfaceandabstraction;

public class Snake extends Reptile{
    private String name;
    public Snake(String name){
        this.name = name;
    }
    public void crawl(){
        System.out.println("Snake is crawling");
    }

    @Override
    public String name() {
        return name;
    }
}
