import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    Stack<Integer> value = new Stack<>();
    Stack<String> infix = new Stack<>();
    Stack<String> prefix = new Stack<>();

    for(int i = 0; i < exp.length(); i++) {
        char ch = exp.charAt(i);
        if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
            int val2 = value.pop();
            int val1 = value.pop();
            int val = operation(val1, val2, ch);
            value.push(val);

            String inval2 = infix.pop();
            String inval1 = infix.pop();
            String inval = "(" + inval1 + ch + inval2 +")";
            infix.push(inval);

            String preval2 = prefix.pop();
            String preval1 = prefix.pop();
            String preval = ch + preval1 + preval2;
            prefix.push(preval);
        } else {
            value.push(ch - '0');
            infix.push(ch + "");
            prefix.push(ch + "");
        }
    }
    System.out.println(value.pop());
    System.out.println(infix.pop());
    System.out.println(prefix.pop());
 }

 public static int operation(int v1, int v2, char opr) {
     if(opr == '+'){
         return v1 + v2;
     }else if(opr == '-') {
         return v1 - v2;
     } else if(opr == '*') {
         return v1 * v2;
     } else {
         return v1/v2;
     }
 }
}
