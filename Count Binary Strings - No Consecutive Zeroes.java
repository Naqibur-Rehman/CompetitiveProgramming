import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int[] dp0 = new int[n + 1];
    int[] dp1 = new int[n + 1];

    // dp0[1] = 1;
    // dp1[1] = 1;

    int oldCountZeroes = 1;
    int oldCountOnes = 1;

    for(int i = 2; i <= n; i++){
    //     dp0[i] = dp1[i - 1];
    //     dp1[i] = dp0[i - 1] + dp1[i - 1];
        int newCountZeroes = oldCountOnes;
        int newCountOnes = oldCountZeroes + oldCountOnes;

        oldCountOnes = newCountOnes;
        oldCountZeroes = newCountZeroes;
    }

    // System.out.println(dp1[n] + dp0[n]);
    System.out.println(oldCountZeroes + oldCountOnes);
 }

}
