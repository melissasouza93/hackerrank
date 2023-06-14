import static java.util.stream.Collectors.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr, int tmArray) {
        // Write your code here
        float zero= 0;
        float pos = 0;
        float neg = 0;
        for(Integer num : arr){
            if(num == 0){
                zero ++;
            }
            if(num < 0){
                neg ++;
            }
            if(num >0 ){
                pos ++;
            }
        }
        System.out.printf("%.6f\n",pos/tmArray);
        System.out.printf("%.6f\n",neg/tmArray);
        System.out.printf("%.6f\n",zero/tmArray);
        
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.plusMinus(arr, n);

        bufferedReader.close();
    }
}
