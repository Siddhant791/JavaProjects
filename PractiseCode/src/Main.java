package src;

import src.equalfunctionality.Dog;

import java.util.Arrays;

public class Main extends Dog {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        int sum = Arrays.stream(array).sum();
        if (sum % 2  != 0){
            System.out.println("odd");
        }
        System.out.println(sum);
        System.out.println(sum / 2);

    }

}
