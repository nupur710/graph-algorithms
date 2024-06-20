package week2_graph_decompositon2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Acyclicity {
    private static int acyclic(ArrayList<Integer>[] adj) {
        int[] degree= new int[adj.length];
        for(int i= 0; i< adj.length; i++) {
            for(int neighbor : adj[i]) {
                degree[neighbor]++;
            }
        }

        Queue<Integer> queue= new LinkedList<Integer>();
        for(int i= 0; i< adj.length; i++) {
            if(degree[i] == 0) {
                queue.add(i);
            }
        }
        int count= 0;
        while(!queue.isEmpty()) {
            int node= queue.poll();
            count++;
            for(int neighbor : adj[node]) {
                degree[neighbor]--;
                if(degree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        int flag = (count == adj.length) ? 0 : 1;
        return flag;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
        }
        System.out.println(acyclic(adj));
    }
}