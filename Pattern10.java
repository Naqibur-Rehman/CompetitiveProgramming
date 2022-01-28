import java.util.*;

public class Main{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt();
    
    int ospace = n/2;
    int ispace = -1;
    
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= ospace; j++) {
            System.out.print("\t");
        }
        
        System.out.print("*\t");
        
        for(int j = 1; j <= ispace; j++) {
            System.out.print("\t");
        }
        if(i > 1 && i< n)
            System.out.print("*\t");
        
        if(i <= n/2){
            ospace--;
            ispace += 2;
        } else {
            ospace ++;
            ispace -= 2;
        }
        System.out.println();
        
    }

 }
}
