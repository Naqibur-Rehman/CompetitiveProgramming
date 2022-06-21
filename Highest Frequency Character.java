import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i=0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(hm.containsKey(ch)){
                int freq = hm.get(ch);
                hm.put(ch, freq+1);
            } else {
                hm.put(ch, 1);
            }
        }

        int max = Integer.MIN_VALUE;
        char ans = '@';
        for(char ch : hm.keySet()){
            int val = hm.get(ch);
            if(val > max){
                max = val;
                ans = ch;
            }
        }
        System.out.println(ans);
    }

}
