package week2_graph_decompositon2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class TopologicalSort {

    private static void sort(ArrayList<Integer>[] adj) {
        Stack<Integer> stack= new Stack<Integer>();
        boolean[] visited= new boolean[adj.length];
        for(int i= 0; i< adj.length; i++) {
            if(!visited[i]) {
                DFSUtil(adj, i, visited, stack);
            }
        }

        for(int i= 0; i< stack.size(); i++) {
            int q= stack.pop();
            System.out.println("lin: " + q);
        }
    }

    private static void DFSUtil(ArrayList<Integer>[] adj, int i, boolean[] visited, Stack<Integer> stack) {
        visited[i]= true;
        for(int j= 0; j<adj[i].size(); j++) {
            if(!visited[adj[i].get(j)]) {
                DFSUtil(adj, adj[i].get(j), visited, stack);
            }
        } stack.add(i);
    }

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int n= scanner.nextInt();
        int m= scanner.nextInt();
        ArrayList<Integer>[] adj= new ArrayList[n];
        for(int i= 0; i< n; i++) {
            adj[i]= new ArrayList<Integer>();
        }
        for(int i= 0; i< m; i++) {
            int x, y;
            x= scanner.nextInt();
            y= scanner.nextInt();
            adj[x-1].add(y-1);
            adj[y-1].add(x-1);
        }

        sort(adj);
    }
}
