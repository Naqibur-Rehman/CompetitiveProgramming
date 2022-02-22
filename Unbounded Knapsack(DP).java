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

		int[] dp = new int[capacity + 1];
		dp[0] = 0;

		for(int cap = 0; cap <= capacity; cap++){
			int max = 0;
			for(int i = 0; i < n; i++){
				if(weights[i] <= cap){
					int remCap = cap - weights[i];
					int remVal = dp[remCap];
					int totalVal = remVal + values[i];

					if(totalVal > max){
						max = totalVal;
					}
				}
			}
			dp[cap] = max;
		}

		System.out.println(dp[capacity]);


	    }
	}
