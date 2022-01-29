import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    
    int n = scanner.nextInt();
    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
        arr[i] = scanner.nextInt();
    }
    
    for(int i = 0; i < n; i++){
        for(int j = i; j < n; j++){
            for(int k = i; k <= j; k++) {
                System.out.print(arr[k]+ "\t");
            }
            System.out.println();
        }
    }
 }

}
