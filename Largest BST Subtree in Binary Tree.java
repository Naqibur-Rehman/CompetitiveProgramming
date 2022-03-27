import java.io.*;
import java.util.*;

public class Main {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }
  
  public static class BSTPair {
    boolean isBST;
    int min;
    int max;
    Node lrgstBstRoot;
    int lrgstBstSize;
  }

  public static BSTPair largestBST(Node node) {
    if(node == null){
      BSTPair bp = new BSTPair();
      bp.isBST = true;
      bp.max = Integer.MIN_VALUE;
      bp.min = Integer.MAX_VALUE;
      bp.lrgstBstRoot = null;
      bp.lrgstBstSize = 0;
      return bp;
    }

    BSTPair lp = largestBST(node.left);
    BSTPair rp = largestBST(node.right);

    BSTPair mp = new BSTPair();
    mp.isBST = lp.isBST && rp.isBST && 
                (node.data >= lp.max && node.data <= rp.min);

    mp.min = Math.min(node.data, Math.min(lp.min, rp.min));
    mp.max = Math.max(node.data, Math.max(lp.max, rp.max));

    if(mp.isBST){
      mp.lrgstBstRoot = node;
      mp.lrgstBstSize = lp.lrgstBstSize + rp.lrgstBstSize + 1;
    } else if(lp.lrgstBstSize > rp.lrgstBstSize){
      mp.lrgstBstRoot = lp.lrgstBstRoot;
      mp.lrgstBstSize = lp.lrgstBstSize;
    } else {
      mp.lrgstBstRoot = rp.lrgstBstRoot;
      mp.lrgstBstSize = rp.lrgstBstSize;
    }

    return mp;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    Node root = construct(arr);
    
    BSTPair p = largestBST(root);
    System.out.println(p.lrgstBstRoot.data+ "@" + p.lrgstBstSize);
  }

}
