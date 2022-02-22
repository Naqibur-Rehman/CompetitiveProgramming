import java.io.*;
import java.util.*;

public class Main {

	
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int[] values = new int[n];
		for(int i = 0; i < n; i++){
			values[i] = scn.nextInt();
		}

		int[] weights = new int[n];
		for(int i = 0; i < n; i++){
			weights[i] = scn.nextInt();
		}

		Item[] items = new Item[n];
		for(int i = 0; i < n; i++){
			double r = (values[i] * 1.0)/weights[i];
			Item item = new Item(values[i], weights[i], r);
			items[i] = item;
		}

		int capacity = scn.nextInt();
		
		Arrays.sort(items);

		double vib = 0;
		int rcap = capacity;
		
		for(int i = n - 1; i >= 0; i--){
			if(items[i].wt <= rcap){
				vib += items[i].val;
				rcap -= items[i].wt;
			} else{
				vib += items[i].val * ((double)rcap / items[i].wt);
				rcap = 0;
				break;
			}
		}
		System.out.println(vib);
		
	}

	public static class Item implements Comparable<Item>{
		int val;
		int wt;
		double r;

		Item(int val, int wt, double r){
			this.val = val;
			this.wt = wt;
			this.r = r;
		}

		public int compareTo(Item o){
			if(this.r > o.r){
				return 1;
			} else if (this.r < o.r){
				return -1;
			} else{
				return 0;
			}
		}
	}

}

