import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        ArrayList<String> words = getKPC(str);
        System.out.println(words);
    }

    static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
    
    public static ArrayList<String> getKPC(String str) {
        if(str.length() == 0){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        // 573
        char ch = str.charAt(0);    // 5
        String ros = str.substring(1);  //73
        ArrayList<String> rres = getKPC(ros);   // words of 73
        ArrayList<String> mres = new ArrayList<>();
        
        String codeForEach = codes[ch - '0'];
        for(int i = 0 ; i < codeForEach.length(); i++){
            char chCode = codeForEach.charAt(i);
            for(String rstr: rres){
                mres.add(chCode + rstr);
            }
        }
        
        return mres;
    }

}
