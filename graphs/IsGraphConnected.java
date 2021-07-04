import java.io.*;
import java.util.*;

class Main {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }


        boolean[] visited = new boolean[vtces];
        int count = 0;
        for (int i = 0; i < vtces; i++) {
            if (!visited[i]) {
                ArrayList<Integer> currentComp = new ArrayList<>();
                performDFS(graph, visited, i, currentComp);
                count++;
                if (count > 1) {
                    System.out.println("false");
                    return;
                }

            }
        }
        System.out.println("true");
    }

    private static void performDFS(ArrayList<Edge>[] graph, boolean[] visited, int src, ArrayList<Integer> currentComp) {


        visited[src] = true;
        currentComp.add(src);
        for (Edge currentEdge : graph[src]) {
            if (!visited[currentEdge.nbr]) {
                performDFS(graph, visited, currentEdge.nbr, currentComp);
            }

        }


    }

}