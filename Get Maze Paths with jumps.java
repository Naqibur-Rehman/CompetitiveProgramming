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
        
        
        ArrayList<String> paths = new ArrayList<>();
        
        // horizontal 
        for(int jump = 1; jump <= dc - sc; jump++){
            ArrayList<String> hPaths = getMazePaths(sr, sc+jump, dr, dc);
            for(String path : hPaths){
                paths.add("h" + jump + path);
            }
        }
        
        // vertical 
        for(int jump = 1; jump <= dr - sr; jump++){
            ArrayList<String> vPaths = getMazePaths(sr+jump, sc, dr, dc);
            for(String path : vPaths){
                paths.add("v" + jump + path);
            }
        }
        
        // diagonal 
        for(int jump = 1; jump <= dc - sc && jump <= dr - sr; jump++){
            ArrayList<String> dPaths = getMazePaths(sr+jump, sc+jump, dr, dc);
            for(String path : dPaths){
                paths.add("d" + jump + path);
            }
        }
        
        return paths;
    }

}
