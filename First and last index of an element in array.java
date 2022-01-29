import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner (System.in);
    int n = scn.nextInt ();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++)
    {
      arr[i] = scn.nextInt ();
    }
    
    int data = scn.nextInt ();
    int low = 0;
    int high = arr.length - 1;
    int last_index = -1;
    int first_index = -1;
    
    //last index
    while (low <= high){
        int mid = (low + high) / 2;
      if (data < arr[mid])
      {
        high = mid - 1;
      }
      else if (data > arr[mid])
      {
        low = mid + 1;
      }
      else
      {
        last_index = mid;
        low = mid + 1;  
      }
    }
    
    // first index
    low = 0;
    high = arr.length - 1;
    while (low <= high){
        int mid = (low + high) / 2;
      if (data < arr[mid])
      {
        high = mid - 1;
      }
      else if (data > arr[mid])
      {
        low = mid + 1;
      }
      else
      {
        first_index = mid;
        high = mid - 1;  
      }
    }
    
    System.out.println (first_index);
    System.out.println (last_index);
 }

}
