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

        int src = Integer.parseInt(br.readLine());
        int dest = Integer.parseInt(br.readLine());

        ArrayList<String> output = new ArrayList<>();

        boolean[] visited = new boolean[vtces];
        StringBuilder currentPath = new StringBuilder();
        currentPath.append(src);
        getAllPathFromSourceToDest(graph, src, dest, visited, currentPath, output);

        for (String outputPath : output)
            System.out.println(outputPath);

    }

    private static void getAllPathFromSourceToDest(ArrayList<Edge>[] graph, int src, int dest,
                                                   boolean[] visited, StringBuilder currentPath, ArrayList<String> output) {
        if (src == dest) {
            output.add(currentPath.toString());
            return;
        }
        visited[src] = true;
        for (Edge currentEdge : graph[src]) {
            if (!visited[currentEdge.nbr]) {
                currentPath.append(currentEdge.nbr);
                getAllPathFromSourceToDest(graph, currentEdge.nbr, dest, visited, currentPath, output);
                currentPath.deleteCharAt(currentPath.length() - 1);
                visited[currentEdge.nbr] = false;
            }


        }


    }


}