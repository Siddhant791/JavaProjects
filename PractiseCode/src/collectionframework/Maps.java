package src.collectionframework;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Maps {

    // Initalize map method 1
    public Map<Integer, String> map = new HashMap<>() {{
        put(1, "Sid");
        put(2, "Harish");
        put(3 , "Tanya");
    }};

    Set<Map.Entry<Integer,String>> setEntry = map.entrySet();

    public void printAllElementsInMap(){
        for (Map.Entry<Integer, String> entry : setEntry){
            System.out.println("Key is " + entry.getKey() + " and value is " + entry.getValue());
        }

        map.forEach((key, value) -> System.out.println("Key is " + key + " and value is " + value));
    }

    public Map<Integer, String> filterMapIfKeyIsOdd(){
        return map
                .entrySet()
                .stream()
                .filter( i -> i.getKey() % 2 == 0)
                .collect(Collectors.toMap(entry -> entry.getKey() , entry -> entry.getValue()));
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }


    public void groupBy(){
        List<String> listOfStrings = List.of("Siddhant","Harish", "Siddhant", "Tanya");

        listOfStrings
                .stream()
                .collect(Collectors.groupingBy(c-> c,Collectors.counting()))
                .forEach((key, value) -> System.out.println(key + " : " + value));


    }
}
