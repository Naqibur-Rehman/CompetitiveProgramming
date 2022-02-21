import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i <arr.length; i++){
            arr[i] = scn.nextInt();
        }

        int amount = scn.nextInt();

        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(i >= arr[j]){
                    dp[i] += dp[i - arr[j]]; 
                }
            }
        }

        System.out.println(dp[amount]);
    }
}
