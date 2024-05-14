package week1_graph_decomposition1;

import java.util.ArrayList;
import java.util.Scanner;

public class ConnectedComponents {
    private static int numberOfComponents(ArrayList<Integer>[] adj) {
        boolean[] visited= new boolean[adj.length];
        int count= 0;
        for(int i= 0; i< adj.length; i++) {
            if(visited[i] == false) {
                DFS(i, visited, adj);
                count++;
            }
        }

        return count;
    }

    private static void DFS(int v, boolean[] visited, ArrayList<Integer>[] adj) {
        visited[v]= true;
        for(int j = 0; j< adj[v].size(); j++) {
            if(visited[adj[v].get(j)] == false) {
                DFS(adj[v].get(j), visited, adj);
            }
        }
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
            adj[y - 1].add(x - 1);
        }
        int r= 0;
        System.out.println(numberOfComponents(adj));
    }
}

