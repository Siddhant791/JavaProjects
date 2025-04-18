import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Paranthesis {
    public boolean isValid(String s) {
        ArrayList<Character> closed = new ArrayList(List.of(')','}',']'));
        ArrayList<Character> opened = new ArrayList(List.of('(','{','['));
        Stack<Character> stack = new Stack();
        Map<Character,Character> map = Map.of(
                '(',')',
                '[',']',
                '{','}'
        );
        // )
        // (
        for(Character c:s.toCharArray()){
            if (opened.contains(c)){
                stack.push(c);
            }
            else if(closed.contains(c)){
                if (stack.isEmpty() || map.get(stack.pop())!=c){
                    return false;
                }
            }
            else {
                System.out.println("Invalid expected input");
            }
        }

        return stack.isEmpty();
    }

}
