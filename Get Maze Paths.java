import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        System.out.println(getMazePaths(1,1, n, m));
        
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        
        if (sc == dc && sr == dr) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        
        ArrayList<String> hPaths =  new ArrayList<>(); 
        ArrayList<String> vPaths =  new ArrayList<>();
        
        if (sc < dc){
            hPaths = getMazePaths(sr, sc+1, dr, dc);
        }
        
        if (sr < dr){
            vPaths = getMazePaths(sr+1, sc, dr, dc);
        }
        
        ArrayList<String> paths = new ArrayList<>();
        
        for(String path : hPaths){
            paths.add("h" + path);
        }
        
        for(String path : vPaths){
            paths.add("v" + path);
        }
        
        return paths;
    }

}
