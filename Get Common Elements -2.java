import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n1 = scn.nextInt();
    int[] arr1 = new int[n1];
    for(int i = 0; i < n1; i++){
        arr1[i] = scn.nextInt();
    }
    int n2 = scn.nextInt();
    int[] arr2 = new int[n2];
    for(int i = 0; i < n2; i++){
        arr2[i] = scn.nextInt();
    }

    HashMap<Integer, Integer> hm = new HashMap<>();
    for(int val: arr1){
      if (hm.containsKey(val)) {
        int freq = hm.get(val);
        hm.put(val, freq+1);
      } else {
       hm.put(val, 1); 
      }
    }

    for (int val : arr2) {
        if(hm.containsKey(val)){
          if(hm.get(val) == 0){
            continue;
          }else{
            System.out.println(val);
            int freq = hm.get(val);
            hm.put(val, freq-1);
          }
          
        }
    }

 }

}