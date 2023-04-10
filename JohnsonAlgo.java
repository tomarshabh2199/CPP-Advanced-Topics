/*
 * Johnson’s algorithm finds the shortest paths between all pairs of vertices in a weighted directed graph.
 *  It allows some of the edge weights to be negative numbers, but no negative-weight cycles may exist.
 *  It uses the Bellman-Ford algorithm to re-weight the original graph, removing all negative weights.
 *  Dijkstra’s algorithm is applied on the re-weighted graph to compute the shortest path between all pairs of vertices.
 */

/*
 * Algorithm Description

Using Dijkstra’s algorithm, the shortest paths between all pairs of vertices in O(V2logV) can be found.
However, Dijkstra does not work with negative weights. To avoid this problem, Johnson’s algorithm uses a technique called reweighting.

Reweighting is a process by which each edge weight is changed to satisfy two properties-


For all pairs of vertices u, v in the graph, if the shortest path exists between those vertices before reweighting, it must also be the shortest path between those vertices after reweighting.
For all edges, (u, v), in the graph, they must have a non-negative weight (u, v).

Johnson’s algorithm uses Bellman-Ford to reweight the edges. Bellman-Ford is also able to detect negative weight cycles if present in the original graph.
*/

import java.util.ArrayList.*;
import java.util.Arrays;

public class Graph{
    private static class Neighbour{
        int destination;
        int weight;

        Neighbour(int destination,int weight)
        {
            this.destination=destination;
            this.weight=weight;
        }
    }
    
    private int vertices;
    private final ArrayList<ArrayList<Neighbour>>adjacenyList;

    // On using the below constructor,
    // edges must be added manually
    // to the graph using addEdge()

    public Graph(int vertices)
    {
        this.vertices=vertices;

        adjacenyList=new ArrayList<>(vertices);
        for(int i=0;i<vertices;i++)
           adjacencyList.add(new ArrayList<>());
    }
       // On using the below constructor,
    // edges will be added automatically
    // to the graph using the adjacency matrix

    public Graph(int vertices,int[][] adjacencyMatrix)
    {
        this(vertices);

        for(int i=0;i<vertices;i++){
            for(int j=0;j<vertices;j++){
                if(adjacencyMatrix[i][j]!=0)
                  addEdge(i,j,adjacencyMatrix[i][j]);
            }
        }
    }
    
    public void addEdge(int source,int destination,int weight)
    {
        adjacenyList.get(source).add(new Neighbour(destination,weight));
    }

        // Time complexity of this
    // implementation of dijkstra is O(V^2).
    
    public int[] dijkstra(int source)
    {
        boolean[] isVisited=new boolean[vertices];
        int[] distance=new int[vertices];

        Arrays.fill(distance,Integer.MAX_VALUE);
        distance=0;

        for(int vertex=0;vertex<vertices;vertex++){
            int minDistanceVertex=findMinDistanceVertex(distance,isVisited);
            isVisited[minDistanceVertex]=true;

            for(Neighbour neighbour: adjacenyList.get(minDistanceVertex)){
                int destination=neighbour.destination;
                int weight=neighbour.weight;
                
                if(!isVisited[destination] && distance[minDistanceVertex]+weight<distance[destination])
                   distance[destination]=distance[minDistanceVertex]+weight;

            }
        }
        return distance;
    }

    //Method used by int[] dijkstra(int)

    private int findMinDistanceVertex(int[] distance, boolean[] isVisited)
    {
        int minIndex=-1, minDistance=Integer.MAX_VALUE;

        for(int vertex=0;vertex<vertices;vertex++){
            if(!isVisited[vertex] && distance[vertex]<=minDistance){
                minDistance=distance[vertex];
                minIndex=vertex;
            }
        }
        return minIndex;
    }

    // Returns null if
    // negative weight cycle is detected
    public int[] bellmanford(int source)
    {
        int[] distance=new int[vertices];

        Arrays.fill(distance,Integer.MAX_VALUE);
        distance=0;

        for(int i=0;i<vertices-1;i++){
            for(int currentVertex=0;currentVertex<vertices;currentVertex++){
                for(Neighbour neighbour:adjacencyList.get(currentVertex)){
                    if(distance[currentVertex]!=Integer.MAX_VALUE && distance[currentVertex]+neighbour.weight<distance[neighbour.destination]){
                        distance[neighbour.destination]=distance[currentVertex]+neighbour.weight;
                    }
                }
            }
        }
       
        for(int currentVertex=0;currentVertex<vertices;currentVertex++){
            for(Neighbour neighbour:adjacenyList.get(currentVertex)){
                if(distance[currentVertex]!=Integer.MAX_VALUE && distance[currentVertex]+neighbour.weight<distance[neighbour.destination])
                   return null;
            }
        }
      return distance;
    }
     // Returns null if negative
    // weight cycle is detected

    public int[][] johnsons()
    {
        // Add a new vertex q to the original graph,
        // connected by zero-weight edges to
        // all the other vertices of the graph

        this.vertices++;
        adjacencyList.add(new ArrayList<>());
        for(int i=0;i<vertices-1;i++)
          adjacencyList.get(vertices-1).add(new Neighbour(i,0));

        // Use bellman ford with the new vertex q
        // as source, to find for each vertex v
        // the minimum weight h(v) of a path
        // from q to v.
        // If this step detects a negative cycle,
        // the algorithm is terminated.
 
        int[]h=bellmanford(vertices-1);
        if(h==null)
           return null;
        
        // Re-weight the edges of the original graph using the
        // values computed by the Bellman-Ford algorithm.
        // w'(u, v) = w(u, v) + h(u) - h(v).

        for(int u=0;u<vertices;u++){
            ArrayList<Neighbour>neighbours=adjacencyList.get(u);

            for(Neighbour neighbour:neighbours){
                int v=neighbour.destination;
                int w=neighbour.weight;

                //new weight
                neighbour.weight=w+h[u]-h[v];
            }
        }
        // Step 4: Remove edge q and apply Dijkstra
        // from each node s to every other vertex
        // in the re-weighted graph
         
        adjacencyList.remove(vertices-1);
        vertices--;

        int[][] distances=new int[vertices][];

        for(int s=0;s<vertices;s++)
           distances[s]=dijkstra(S);
        
        // Compute the distance in the original graph
        // by adding h[v] - h[u] to the
        // distance returned by dijkstra
       
        for(int u=0;u<vertices;u++){
            for(int v=0;v<vertices;v++){

                //if no edge exist,continue
                if(distance[u][v]==Integer.MAX_VALUE)
                   continue;
                distances[u][v]+=(h[v]-h[u]);
            }
        }

        return distances;
    
    }

    //Driver code
    public static void main(String[] args){
        final int vertices=4;
        final int[][] matrix={ { 0, 0, -2, 0 },
        { 4, 0, 3, 0 },
        { 0, 0, 0, 2 },
        { 0, -1, 0, 0 } };

        //Intialization
        Graph graph=new Graph(vertices,matrix);

        //Function call
        int[][] distances=graph.johnsons();

        if(distances==null){
            System.out.println("Negative weight cycle detected");
        return;
        }
       
        // The code fragment below outputs
        // an formatted distance matrix.
        // Its first row and first
        // column represent vertices
        System.out.println("Distance matrix:");
 
        System.out.print("   \t");
        for (int i = 0; i < vertices; i++)
            System.out.printf("%3d\t", i);
 
        for (int i = 0; i < vertices; i++) {
            System.out.println();
            System.out.printf("%3d\t", i);
            for (int j = 0; j < vertices; j++) {
                if (distances[i][j] == Integer.MAX_VALUE)
                    System.out.print(" X\t");
                else
                    System.out.printf("%3d\t",
                                      distances[i][j]);
            }
        }
    }
}

/*
 * Output
Distance matrix:
         0      1      2      3    
  0      0     -1     -2      0    
  1      4      0      2      4    
  2      5      1      0      2    
  3      3     -1      1      0    
Time Complexity: O(V2log V + VE), The time complexity of Johnson’s algorithm becomes the same as Floyd Warshall when the graphs are complete (For a complete graph E = O(V2). But for sparse graphs, the algorithm performs much better than Floyd Warshall.
Auxiliary Space: O(V*V)
 */