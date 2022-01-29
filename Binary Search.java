import java.io.*;

import java.util.*;

public class Main {

  public static void main(String[] args) {
    int[]arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
    int data = 70;
    int low = 0;
    int high = arr.length - 1;

    while (low <= high) {
      int mid = (low + high) / 2;
      if (data > arr[mid]) {
        low = mid + 1;
      } else if (data < arr[mid]) {
        high = mid - 1;
      } else {
        System.out.println(mid);
        return;
      }
    }
    System.out.println(-1);
  }
}
