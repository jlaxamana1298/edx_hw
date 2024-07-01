import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays;

public class GraphTester {
    public static void main(String[] args) {
        // Create verticies
        Vertex<Integer> v1 = new Vertex<>(1);
        Vertex<Integer> v2 = new Vertex<>(2);
        Vertex<Integer> v3 = new Vertex<>(3);
        Vertex<Integer> v4 = new Vertex<>(4);
        Vertex<Integer> v5 = new Vertex<>(5);

        // Create edges
        Edge<Integer> e1 = new Edge<>(v1, v2, 1);
        Edge<Integer> e2 = new Edge<>(v1, v3, 1);
        Edge<Integer> e3 = new Edge<>(v2, v4, 1);
        Edge<Integer> e4 = new Edge<>(v3, v5, 1);

        // Create set of edges and verts
        Set<Vertex<Integer>> verticies = new HashSet<>(Arrays.asList(v1, v2, v3, v4, v5));
        Set<Edge<Integer>> edges = new HashSet<>(Arrays.asList(e1, e2, e3, e4));

        // create graph
        Graph<Integer> graph = new Graph<>(verticies, edges);

        // Perform BFS
        List<Vertex<Integer>> visitedSet = new ArrayList<>();
        visitedSet = GraphAlgorithms.bfs(v1, graph);
        System.out.println(visitedSet);

        // Perform DFS
        visitedSet = GraphAlgorithms.dfs(v1, graph);
        System.out.println(visitedSet);
    }
}
