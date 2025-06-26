package src.collectionframework;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class QuestionMapStreams {

    public static Map<String,String> getFirstCharacterToValue(List<String> list){
        return list.stream().collect(Collectors.toMap(
                k -> k,
                s -> s,
                (prev , desired) -> prev
        ));
    }
}
