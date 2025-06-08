package src.java365;

public class Main365 {
    public static void main(String[] args) {
        System.out.println(FinallyOverride.test());
    }

    static class FinallyOverride {

        static int test() {
            try {
                return 1;
            } finally {
                return 2;
            }
        }
    }
}
