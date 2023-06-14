import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Solution {
    // S (split) or C (combine)
    // M indicates method, C indicates class, and V indicates variable

    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("arquivo.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));

        String linha = "";
        while(linha != null){
            linha = bufferedReader.readLine();
            if(linha == null){
                continue;
            }
            String[] dados = linha.split(";");
            String r = dados[2];
            
            switch(dados[0]){
                case "C":
                    for(int i=0 ; i< r.length() ; i++){
                        if(r.charAt(i) == ' '){
                            r = r.substring(0, i) +
                            r.substring(i+1, i+2).toUpperCase() +
                            r.substring(i+2, r.length());
                        }
                    }
                    if(dados[1].equals("M")){
                        r = r + "()";
                    }
                    if(dados[1].equals("C")){
                        r = r.substring(0, 1).toUpperCase()+
                            r.substring(1, r.length());
                    }
                break;
                case "S":
                    r = r.replace("()", "");
                    for(int j=0; j < r.length(); j++){
                        if(r.charAt(j) >= 'A' && r.charAt(j) <= 'Z'){
                            r = r.substring(0, j)+
                            " " + r.substring(j, j+1).toLowerCase() +
                            r.substring(j+1, r.length());
                        }
                    }
                    
                break;
            }
            System.out.println(r.trim());
        }
        bufferedReader.close();
    }
}