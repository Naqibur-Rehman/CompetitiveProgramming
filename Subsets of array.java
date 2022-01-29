import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    
     Scanner scn = new Scanner (System.in);
    int n = scn.nextInt ();
    int[] arr = new int[n];
    for (int i = 0; i < arr.length; i++)
    {
      arr[i] = scn.nextInt ();
    }
    int limit = (int) Math.pow (2, arr.length);
    
    for (int i = 0; i < limit; i++){
        String set = "";
        int temp = i;
     for (int j = arr.length - 1; j >= 0; --j)
      {
        int rem = temp % 2;
        temp = temp / 2;
        if (rem == 0) //nothing to be printed
        {
          set = "-	" + set;
        }
        else
        {
          // we print the element, so we add it to our answer string
          set = arr[j] + "	" + set;
        }
      }
      System.out.println (set); // printing the required pattern line-by-line
    }
 }

}
