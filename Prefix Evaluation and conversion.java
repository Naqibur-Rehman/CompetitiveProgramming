import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    Stack<Integer> value = new Stack<>();
    Stack<String> infix = new Stack<>();
    Stack<String> postfix = new Stack<>();

    for(int i = exp.length() - 1; i >= 0; i--){
        char ch = exp.charAt(i);
        if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
            int val1 = value.pop();
            int val2 = value.pop();
            int val = operation(val1, val2, ch);
            value.push(val);

            String inval1 = infix.pop();
            String inval2 = infix.pop();
            String inval = "(" + inval1 + ch + inval2 + ")";
            infix.push(inval);

            String postval1 = postfix.pop();
            String postval2 = postfix.pop();
            String postval = postval1 + postval2 + ch;
            postfix.push(postval);
        } else {
            value.push(ch - '0');
            infix.push(ch + "");
            postfix.push(ch + "");
        }
    }
    System.out.println(value.pop());
    System.out.println(infix.pop());
    System.out.println(postfix.pop());
 }

 public static int operation(int v1, int v2, char opr) {
     if(opr == '+') {
         return v1 + v2;
     } else if(opr == '-'){
         return v1 - v2;
     } else if(opr == '*') {
         return v1 * v2;
     } else {
         return v1 / v2;
     }
 }
}
