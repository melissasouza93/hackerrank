import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        String pattern = "hh:mm:ssa";
        DateTimeFormatter formato = DateTimeFormatter.ofPattern(pattern);
        LocalTime data =  LocalTime.parse(s, formato);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        return dtf.format(data);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("arquivo.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("saida.txt"));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

