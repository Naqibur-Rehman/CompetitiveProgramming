import java.util.*;
import java.io.*;

public class Main {

   public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      String s = scn.nextLine();
      
      Stack<Character> st = new Stack<>();

      for(int i = 0; i < s.length(); i++){
         char ch = s.charAt(i);
         if(ch == '(' || ch == '[' || ch == '{') {
            st.push(ch);
         } else if (ch == ')') {
            boolean val = handleClosing(st, '(');
            if(val == false){
               System.out.println(val);
               return;
            }
         } else if (ch == ']'){
            boolean val = handleClosing(st, '[');
            if(val == false){
               System.out.println(val);
               return;
            }
         } else if(ch == '}') {
            boolean val = handleClosing(st, '{');
            if(val == false){
               System.out.println(val);
               return;
            }
         }
      }

      if(st.size() == 0){
         System.out.println(true);
      } else {
         System.out.println(false);
      }

   }

   public static boolean handleClosing(Stack<Character> st, char ch) {
      if(st.size() == 0) {
         return false;
      } else if(st.peek() != ch){
         return false;
      } else {
         st.pop(); 
         return true;
      }
          
   }
}
