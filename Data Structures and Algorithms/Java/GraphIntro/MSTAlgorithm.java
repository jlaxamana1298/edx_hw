import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Your implementation of Prim's algorithm.
 */
public class MSTAlgorithm {

    /**
     * Runs Prim's algorithm on the given graph and returns the Minimum
     * Spanning Tree (MST) in the form of a set of Edges. If the graph is
     * disconnected and therefore no valid MST exists, return null.
     *
     * You may assume that the passed in graph is undirected. In this framework,
     * this means that if (u, v, 3) is in the graph, then the opposite edge
     * (v, u, 3) will also be in the graph, though as a separate Edge object.
     *
     * The returned set of edges should form an undirected graph. This means
     * that every time you add an edge to your return set, you should add the
     * reverse edge to the set as well. This is for testing purposes. This
     * reverse edge does not need to be the one from the graph itself; you can
     * just make a new edge object representing the reverse edge.
     *
     * You may assume that there will only be one valid MST that can be formed.
     *
     * You should NOT allow self-loops or parallel edges in the MST.
     *
     * You may import/use java.util.PriorityQueue, java.util.Set, and any
     * class that implements the aforementioned interface.
     *
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     *
     * The only instance of java.util.Map that you may use is the adjacency
     * list from graph. DO NOT create new instances of Map for this method
     * (storing the adjacency list in a variable is fine).
     *
     * You may assume that the passed in start vertex and graph will not be null.
     * You may assume that the start vertex exists in the graph.
     *
     * @param <T>   The generic typing of the data.
     * @param start The vertex to begin Prims on.
     * @param graph The graph we are applying Prims to.
     * @return The MST of the graph or null if there is no valid MST.
     */
    public static <T> Set<Edge<T>> prims(Vertex<T> start, Graph<T> graph) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        // 1. initialize visted set
        List<Vertex<T>> visitedSet = new ArrayList<>();

        // 2. initialize priority queue
        PriorityQueue<VertexDistance<T>> vdPriorityQueue = new PriorityQueue<>();

        // 3. initialize MST
        Set<Edge<T>> mstSet = new HashSet<>();

        // 4. enqueue each starting edge in G
        Map<Vertex<T>, List<VertexDistance<T>>> currAdjList = new HashMap<>();
        currAdjList = graph.getAdjList();
        // for all verticies adjacent to start vertex
        for (int i = 0; i < currAdjList.get(start).size(); i++) {
            Vertex<T> connectedVertex = currAdjList.get(start).get(i).getVertex();
            int distance_temp = currAdjList.get(start).get(i).getDistance();
            VertexDistance<T> connectedVertexDistance = new VertexDistance<>(connectedVertex, distance_temp);

            // enqueue connected vertex and distance into priority queue
            vdPriorityQueue.add(connectedVertexDistance);
        }

        // 5. mark start as visited
        visitedSet.add(start);

        // 6. while PQ not empty and VS not full
        Vertex<T> currVertex = start;
        Set<Edge<T>> edgeList = graph.getEdges();
        while (!vdPriorityQueue.isEmpty() && (visitedSet.size() < graph.getVertices().size())) {
            // 6a. dequeue edge (connected vertex)
            VertexDistance<T> currVertexDistance = vdPriorityQueue.poll();
            // 6b. if vertex not in VS
            if (!visitedSet.contains(currVertexDistance.getVertex())) {
                currVertex = currVertexDistance.getVertex();
                // add vertex to VS
                visitedSet.add(currVertexDistance.getVertex());
                // add edges
                for (Edge<T> currEdge : edgeList) {
                    if ((currEdge.getU().equals(currVertex) && visitedSet.contains(currEdge.getV())) ||
                        (currEdge.getV().equals(currVertex) && visitedSet.contains(currEdge.getU()))) {
                            mstSet.add(currEdge);
                            break;
                    }
                }
                // enqueue all edges connected to found vertex not in visited set
                for (VertexDistance<T> vd : currAdjList.get(currVertex)) {
                    if (!visitedSet.contains(vd.getVertex())) {
                        vdPriorityQueue.add(vd);
                    }
                }
            }
        }

        return mstSet;
    }
}