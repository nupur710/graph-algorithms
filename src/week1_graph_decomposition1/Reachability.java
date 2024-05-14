package week1_graph_decomposition1;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Reachability {
    private static int reach(ArrayList<Integer>[] adj, int x, int y) {
        if(x == y) return 1; //same vertex
        boolean[] visited= new boolean[adj.length]; //adj length= no. of vertices
        //visit each vertex
        for(int i= 0; i < adj.length; i++) visited[i]= false;
        Queue<Integer> queue= new LinkedList<Integer>();
        //visit current node
        visited[x]= true;
        //enqueue
        ((LinkedList<Integer>) queue).add(x);
        while(!queue.isEmpty()) {
            x= queue.remove(); //dequeue visited vertex
            for(int i= 0; i< adj[x].size(); i++) {
                if(adj[x].get(i) == y) return 1;
                //visit neighbours
                if(!visited[adj[x].get(i)]) {
                    visited[adj[x].get(i)]= true;
                    ((LinkedList<Integer>) queue).add(adj[x].get(i));
                }
            }
        }
        return 0;
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
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(reach(adj, x, y));
    }
}
