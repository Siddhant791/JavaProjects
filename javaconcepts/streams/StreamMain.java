package streams;

import java.util.Arrays;
import java.util.Collections;

public class StreamMain {

    public static void main(String[] args) {
        System.out.println("In Main");
        String input = "sida";

//        System.out.println(StringUtility.convertString(input, StringUtility::convertToUpperCase));

        String output = StringUtility.convertString(input, (s) -> {
            String result = "";
            for (char c: s.toCharArray()) {
                if (c == 'a' || c == 'A'){
                    continue;
                }
                result+= c;
            }
            return result;
        });

        System.out.println(output);

        int[] arr = {1,2,3,4,5};
        StringUtility.reverseArray(arr);
        System.out.println(Arrays.toString(arr));

//        System.out.println(StringUtility.convertString(input, String::trim));

        // trim method is not static method, so we need to use instance of String class
    }


    // The function signature must be same as per the functional interface method signature


    static class StringUtility {

        public static String convertToUpperCase(String input) {
            String result = "";
            for(char c : input.toCharArray()) {
                if(c < 'a' || c > 'z') {
                    result+= c;
                    continue;
                }
                char out = (char) (c - ('a' - 'A'));
                result+= out;
            }
            return result;
        }

        public static String convertToLowerCase(String input) {
            String result = "";
            for(char c : input.toCharArray()) {
                if(c < 'A' || c > 'Z') {
                    result+= c;
                    continue;
                }
                char out = (char) (c + ('a' - 'A'));
                result+= out;
            }
            return result;
        }

        public static String convertString(String input, MyStringUtility function) {
            return function.convert(input);
        }

        @FunctionalInterface
        interface MyStringUtility {
            String convert(String input);
        }

        public static void reverseArray(int[] arr) {
            int start = 0;
            int end = arr.length - 1;
            int temp = 0;
            while (start < end) {
                temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;

                start++;
                end--;
            }
        }

    }


}

