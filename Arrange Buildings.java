import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    long n = scn.nextInt();

    long oldBuild = 1;
    long oldSpace = 1;

    for(int i = 2; i <= n; i++){
        long newBuild = oldSpace;
        long newSpace = oldSpace + oldBuild;

        oldBuild = newBuild;
        oldSpace = newSpace;
    }
    
    long total = oldSpace + oldBuild;
    System.out.println(total*total);
 }

}
