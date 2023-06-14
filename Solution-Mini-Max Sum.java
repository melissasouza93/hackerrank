import static java.util.stream.Collectors.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Long> arr) {
        // Write your code here
        long minSum = 0;
        long maxSum = 0;
        long ret = 0;
        List<Long> arraySum = new ArrayList(); 
        //1
        arraySum.addAll(arr.subList(1, 5));
        ret = soma(arraySum);
        minSum = ret;
        maxSum = ret;
        
        //2
        arraySum.clear();
        arraySum.addAll(arr.subList(0, 1));
        arraySum.addAll(arr.subList(2, 5));
        ret = soma(arraySum);
        
        if(ret > maxSum){
            maxSum = ret;
        }
        if(ret < minSum){
            minSum = ret;
        }
        //3
        arraySum.clear();
        arraySum.addAll(arr.subList(0, 2));
        arraySum.addAll(arr.subList(3, 5));
        ret = soma(arraySum);
        
        if(ret > maxSum){
            maxSum = ret;
        }
        if(ret < minSum){
            minSum = ret;
        }
        //4
        arraySum.clear();
        arraySum.addAll(arr.subList(0, 3));
        arraySum.addAll(arr.subList(4, 5));
        ret = soma(arraySum);
        
        if(ret > maxSum){
            maxSum = ret;
        }
        if(ret < minSum){
            minSum = ret;
        }
        //5
        arraySum.clear();
        arraySum.addAll(arr.subList(0, 4));
        ret = soma(arraySum);
        
        if(ret > maxSum){
            maxSum = ret;
        }
        if(ret < minSum){
            minSum = ret;
        }
        
        System.out.println(minSum + " " + maxSum);
    }

    public static long soma(List<Long> arr){
        long soma = 0 ;
        for(long num: arr){
            soma = soma + num;
        }
        return soma;   
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("arquivo.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));


        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
