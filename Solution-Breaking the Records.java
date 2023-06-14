import static java.util.stream.Collectors.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'breakingRecords' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     */

    public static List<Integer> breakingRecords(List<Integer> scores) {
        int min = 0;
        int max = 0;
        int maxRecord = Integer.MIN_VALUE;
        int minRecord = Integer.MAX_VALUE;

        for(int score : scores){
            if(score < minRecord){
                
                if(minRecord != Integer.MAX_VALUE){
                    min ++;
                }
                minRecord = score;
            }
            if(score > maxRecord){
                if(maxRecord != Integer.MIN_VALUE){
                    max++;
                }
                maxRecord = score;
            }

        }
        return List.of(max, min);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("arquivo.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("saida.txt"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.breakingRecords(scores);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}