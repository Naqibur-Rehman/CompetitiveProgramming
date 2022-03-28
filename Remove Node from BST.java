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

  public static Node construct(int[] arr, int lo, int hi) {
    if(lo > hi){
      return null;
    }

    int mid = (lo + hi) / 2;
    int data = arr[mid];

    Node lc = construct(arr, lo, mid - 1);
    Node rc = construct(arr, mid + 1, hi); 

    Node node = new Node(data, lc, rc);

    return node;
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

  public static int size(Node node) {
    if(node == null){
      return 0;
    }
    int lc = size(node.left);
    int rc = size(node.right);

    int s = lc + rc + 1;
    return s;
  }

  public static int sum(Node node) {
    if(node == null){
      return 0;
    }

    int lsum = sum(node.left);
    int rsum = sum(node.right);

    int total = lsum + rsum + node.data;

    return total;
  }

  public static int max(Node node) {
    if(node == null){
      return Integer.MIN_VALUE;
    }

    int max = max(node.right);
    max = Math.max(max, node.data);

    return max;
  }

  public static int min(Node node) {
    if(node == null){
      return Integer.MAX_VALUE;
    }

    int min = min(node.left);
    min = Math.min(min, node.data);

    return min;
  }
  
  public static boolean find(Node node, int find){
    if(node == null){
      return false;
    }
    if(node.data == find){
      return true;
    }

    boolean f = false;
    if(find > node.data){
      f = find(node.right, find);
    }
    if(find < node.data){
      f = find(node.left, find);
    }

    return f;
  }  

  public static Node add(Node node, int data){
    if(node == null){
      Node bn  = new Node(data, null , null);
      return bn;
    }
    
    if(data > node.data){
      node.right = add(node.right, data);
    } else if(data < node.data){
      node.left = add(node.left, data);
    }

    return node;
  }

  public static Node remove(Node node, int data){
    if(node == null){
      return null;
    }
    if(data > node.data){
      node.right = remove(node.right, data);
    } else if (data < node.data){
      node.left = remove(node.left, data);
    } else {
      if(node.left != null && node.right != null){
        int lmax = max(node.left);
        node.data = lmax;
        node.left = remove(node.left, lmax);
        return node;
      } else if (node.left != null){
        return node.left;
      } else if(node.right != null){
        return node.right;
      } else{
        return null;
      }
    }
    return node;
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

    int data = Integer.parseInt(br.readLine());

    ArrayList<Integer> list = new ArrayList<Integer>();
    for(int i = 0; i < arr.length; i++){
      if(arr[i] != null){
        list.add(arr[i]);
      }
    }

    int[] arr1 = new int[list.size()];
    int i = 0;
    for(int val : list){
      arr1[i] = val; 
      i++;
    }

    Arrays.sort(arr1);

    Node root = construct(arr1, 0, arr1.length - 1);
    // display(root);

    Node r = remove(root, data);
    display(r);

  }

}
