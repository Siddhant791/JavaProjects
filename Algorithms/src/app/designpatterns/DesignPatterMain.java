package app.designpatterns;

public class DesignPatterMain {
    public static void main(String[] args){

        System.out.println("Hello design patterns");

        //This is to check Factory design pattern
//        Shape shape = ShapeFactory.getShape("Rectangle",2,4);
//        shape = ShapeFactory.getShape("square",3,4);
//        System.out.println(shape);

        //This is to check builder design pattern
        Computer Lenovo = new ComputerBuilder("1 TB","16 GB").build();
        Computer Mac = new ComputerBuilder("500 GB","4 GB").setOs("Linux").setIsBluetoothEnabled(true).build();
        System.out.println(Lenovo);
        System.out.println(Mac);
    }
}

