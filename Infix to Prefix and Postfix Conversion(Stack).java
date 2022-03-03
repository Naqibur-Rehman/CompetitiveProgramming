import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    Stack<String> prefix = new Stack<>();
    Stack<String> postfix = new Stack<>();
    Stack<Character> operators = new Stack<>();

    for(int i = 0; i < exp.length(); i++){
        char ch = exp.charAt(i);
        if(ch == '('){
            operators.push(ch);
        } else if ((ch >= '0' && ch <= '9') || 
                    (ch >= 'a' && ch <= 'z') ||
                    (ch >= 'A' && ch <= 'Z')){
            prefix.push(ch + "");
            postfix.push(ch +"");   
        } else if(ch == ')'){
            while ( operators.peek() != '(' ) {
                process(operators, prefix, postfix);
            }
            operators.pop();
        } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
            while ( operators.size() > 0 &&
                    operators.peek() != '(' &&
                    precedence(operators.peek()) >= precedence(ch)) {
                process(operators, prefix, postfix);
            }
            operators.push(ch);
        }
    }

    while ( operators.size() > 0) {
        process(operators, prefix, postfix);    
    }

    System.out.println(postfix.pop());
    System.out.println(prefix.pop());

 }

 public static void process(Stack<Character> operators, 
                            Stack<String> prefix,
                            Stack<String> postfix) {
        char opr = operators.pop();
        String preval2 = prefix.pop();
        String preval1 = prefix.pop();
        String preval = opr + preval1 + preval2;
        prefix.push(preval);

        String postval2 = postfix.pop();
        String postval1 = postfix.pop();
        String postval = postval1 + postval2 + opr;
        postfix.push(postval);
     
 }

 public static int precedence(char operator) {
     if(operator == '+' || operator == '-') {
         return 1;
     }else if(operator == '*' || operator == '/'){
         return 2;
     }
     return 0;
 }


}
