import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
        arr[i] = scn.nextInt();
    }

    HashMap<Integer, Boolean> map = new HashMap<>();
    for(int val : arr){
        map.put(val, true);
    }

    for(int val : arr){
        if(map.containsKey(val-1)){
            map.put(val, false);
        }
    }

    int maxLength = 0;
    int maxStartPoint = 0;
    for(int val : arr){
        if(map.get(val) == true){
            int tempLength = 1;
            int tempStartPoint = val;

            while(map.containsKey(tempStartPoint + tempLength)){
                tempLength++;
            }

            if(tempLength > maxLength){
                maxStartPoint = tempStartPoint;
                maxLength = tempLength;
            }
        }
    }

    for(int i = 0; i < maxLength; i++){
        System.out.println(maxStartPoint + i);
    }


 }

}
