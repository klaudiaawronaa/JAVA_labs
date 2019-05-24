package Solution;

import java.util.stream.IntStream;

public class Solution {

    public int[] solution(float[] arr, float target) throws Exception{
        int[] answer = new int[2];
        int index;

        for (int j = 0; j < arr.length; j++) {
            float target1 = target - arr[j];
            index = IntStream.range(0, arr.length) //od-do
                    .filter(i -> target1 == arr[i])
                    .findFirst()
                    .orElse(-1);
            if (index < arr.length && index >= 0) {
                answer[0] = j;
                answer[1] = index;
                break;
            } else answer[1]=-1;
        }

        if(answer[1]<0) throw new Exception ("COULD'N FIND");
        else{
        System.out.println("INDEX1: " + answer[0]);
        System.out.println("INDEX2: " + answer[1]);}

        return answer;

    }
    public static void veryLongComputation() throws InterruptedException {
        Thread.sleep(2000);
    }



}
