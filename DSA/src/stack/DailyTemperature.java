package src.stack;

import java.util.Stack;

public class DailyTemperature {
    public int[] dailyTemperatures(int[] temps) {
        int n = temps.length;
        int[] out = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < n; i++){
            while (!stack.isEmpty() && temps[stack.peek()] < temps[i]){
                out[stack.peek()] = i - stack.pop() ;
            }
            stack.add(i);
        }

        return out;
    }

     public int[] dailyTemperaturesBruteForce(int[] temps){
         int count;
         int n = temps.length;
         int[] out = new int[n];

         for (int i=0 ; i<n; i++){
             // Reset the counter to compute the next value count in the array
             count = 1;
             for (int j = i+1; j<n; j++){
                 if (temps[j] > temps[i]){
                     out[i] = count;
                     break;
                 }
                 count++;
             }
         }

         return out;


     }

     public int[] dailyTemperaturesStackFromBack(int[] temps){
         Stack<int[]> stack = new Stack<>();
         int n = temps.length;
         int i = n - 1;
         int[] out = new int[n];

         while (i >= 0){
             if (stack.isEmpty()){
                 stack.add(new int[]{temps[i], i});
                 out[i] = 0;
                 i--;
                 continue;
             }

             // If new element is greater than the stack peeked element then the existing element doesn't need to be in stack
             // So we pop it out
             while (!stack.isEmpty() && temps[i] >= stack.peek()[0]){
                 stack.pop();
             }

             if (stack.isEmpty()){
                 out[i] = 0;
             } else{

                 // Once we get the greater element that means that's the next greater element
                 out[i] = stack.peek()[1] - i;
             }

             stack.add(new int[]{temps[i], i});

             i--;
         }

         return out;
     }
}
