import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] values = new int[n];
        for(int i = 0; i < values.length; i++){
            values[i] = scn.nextInt();
        }

        int[] weights = new int[n];
        for(int i = 0; i < weights.length; i++){
            weights[i] = scn.nextInt();
        }

        int capacity = scn.nextInt();

        int[][] dp = new int[n + 1][capacity + 1];
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(j >= weights[i - 1]) {
                    int remCap = j - weights[i - 1];
                    if(dp[i - 1][remCap] + values[i - 1] > dp[i - 1][j]){
                        dp[i][j] = dp[i - 1][remCap] + values[i - 1];
                    } else{
                        dp[i][j] += dp[i - 1][j];
                    }
                } else{
                    dp[i][j] += dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[n][capacity]);
    }
}
