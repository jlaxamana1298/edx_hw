import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * Your implementation of various graph traversal algorithms.
 */
public class GraphAlgorithms {

    /**
     * Performs a breadth first search (bfs) on the input graph, starting at
     * the parameterized starting vertex.
     *
     * When exploring a vertex, explore in the order of neighbors returned by
     * the adjacency list. Failure to do so may cause you to lose points.
     *
     * You may import/use java.util.Set, java.util.List, java.util.Queue, and
     * any classes that implement the aforementioned interfaces, as long as they
     * are efficient.
     *
     * The only instance of java.util.Map that you should use is the adjacency
     * list from graph. DO NOT create new instances of Map for BFS
     * (storing the adjacency list in a variable is fine).
     *
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     *
     * You may assume that the passed in start vertex and graph will not be null.
     * You may assume that the start vertex exists in the graph.
     *
     * @param <T>   The generic typing of the data.
     * @param start The vertex to begin the bfs on.
     * @param graph The graph to search through.
     * @return List of vertices in visited order.
     */
    public static <T> List<Vertex<T>> bfs(Vertex<T> start, Graph<T> graph) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        // initialize visted set
        List<Vertex<T>> visitedSet = new ArrayList<>();

        // Initialize queue
        Queue<Vertex<T>> vertexQueue = new LinkedList<>();

        // mark start as visted
        visitedSet.add(start);

        // enqueue start
        vertexQueue.add(start);

        // loop for BFS
        Map<Vertex<T>, List<VertexDistance<T>>> currAdjList = new HashMap<>();
        while (!vertexQueue.isEmpty()) {
            // Dequeue item
            Vertex<T> currentVertex = vertexQueue.poll();

            // get adjacent verticies to currentVertex
            currAdjList = graph.getAdjList();

            // Iterate through current adjacent verticies
            for (int i = 0; i < currAdjList.get(currentVertex).size(); i++) {
                // if vertex not in visited set, mark and enqueue
                if (!visitedSet.contains(currAdjList.get(currentVertex).get(i).getVertex())) {
                    visitedSet.add(currAdjList.get(currentVertex).get(i).getVertex());
                    vertexQueue.add(currAdjList.get(currentVertex).get(i).getVertex());
                }
            }
        }

        return visitedSet;
    }

    /**
     * Performs a depth first search (dfs) on the input graph, starting at
     * the parameterized starting vertex.
     *
     * When exploring a vertex, explore in the order of neighbors returned by
     * the adjacency list. Failure to do so may cause you to lose points.
     *
     * NOTE: This method should be implemented recursively. You may need to
     * create a helper method.
     *
     * You may import/use java.util.Set, java.util.List, and any classes that
     * implement the aforementioned interfaces, as long as they are efficient.
     *
     * The only instance of java.util.Map that you may use is the adjacency list
     * from graph. DO NOT create new instances of Map for DFS
     * (storing the adjacency list in a variable is fine).
     *
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     *
     * You may assume that the passed in start vertex and graph will not be null.
     * You may assume that the start vertex exists in the graph.
     *
     * @param <T>   The generic typing of the data.
     * @param start The vertex to begin the dfs on.
     * @param graph The graph to search through.
     * @return List of vertices in visited order.
     */
    public static <T> List<Vertex<T>> dfs(Vertex<T> start, Graph<T> graph) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        // initialize visted set
        List<Vertex<T>> visitedSet = new ArrayList<>();

        // Call recursive function to get visited Set
        visitedSet = dfs_helper(start, graph, visitedSet);

        return visitedSet;
    }

    // DFS helper recursive function
    private static <T> List<Vertex<T>> dfs_helper(Vertex<T> currentVertex, Graph<T> graph, List<Vertex<T>> visitedSet) {
        // mark start as visited
        visitedSet.add(currentVertex);

        // get adjacent verticies to currentVertex
        Map<Vertex<T>, List<VertexDistance<T>>> currAdjList = new HashMap<>();
        currAdjList = graph.getAdjList();
        // for all verticies adjacent to start vertex
        for (int i = 0; i < currAdjList.get(currentVertex).size(); i++) {
            // if adjacent vertex not visited, call recursive function on that vertex
            if (!visitedSet.contains(currAdjList.get(currentVertex).get(i).getVertex())) {
                dfs_helper(currAdjList.get(currentVertex).get(i).getVertex(), graph, visitedSet);
            }
        }
        
        return visitedSet;
    }
}