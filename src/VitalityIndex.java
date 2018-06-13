import org.graphstream.algorithm.measure.AbstractCentrality;
import org.graphstream.graph.Graph;

public class VitalityIndex extends AbstractCentrality {

    int wienerIndex=0;
    //input count of nodes to V variable
    static final int V=8;

    protected VitalityIndex(String attribute, NormalizationMode normalize) {
        super(attribute, normalize);
    }

    @Override
    public void init(Graph graph) {
        super.init(graph);
    }

    @Override
    protected void computeCentrality() {
        for(int i=0;i<V;i++) {
            wienerIndex = wienerIndex + dijkstra(returnMatrix(graph), i);
        }
        System.out.println("Wiener index "+wienerIndex);

    }

    public int[][] returnMatrix(Graph g){
    int countOfNodes = graph.getNodeCount();
    int matrix[][] = new int [countOfNodes][countOfNodes];
    //System.out.println("Matrix");
        for(int i=0; i<countOfNodes; i++){
        for(int j=0; j<countOfNodes; j++){
            if( graph.getNode(i).hasEdgeBetween(j) == true){
                matrix[i][j] = 1;
            }
            else matrix[i][j] = 0;
            //System.out.print(matrix[i][j] + " ");
        }
        //System.out.print("\n");

    }
    return matrix;
    }


    public int minDistance(int dist[], Boolean sptSet[])
    {
        int min = Integer.MAX_VALUE, min_index=-1;

        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min)
            {
                min = dist[v];
                min_index = v;
            }
        return min_index;
    }

    public int printSolution(int dist[])
    {
        //System.out.println("\nNode   Path");
        int sumOfPathes=0;
        for (int i = 0; i < V; i++) {
            //System.out.println(i + "      " + dist[i]);
            sumOfPathes = sumOfPathes + dist[i];
        }
        //System.out.println("Wiener Index (sum of paths)  " +sumOfPathes);
        return sumOfPathes;
    }


    public int dijkstra(int graph[][], int src)
    {
        int dist[] = new int[V];
        Boolean sptSet[] = new Boolean[V];

        for (int i = 0; i < V; i++)
        {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
        dist[src] = 0;

        // Find shortest path for all vertices
        for (int count = 0; count < V-1; count++)
        {
            int u = minDistance(dist, sptSet);
            sptSet[u] = true;
            for (int v = 0; v < V; v++)

                if (!sptSet[v] && graph[u][v]!=0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u]+graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }
        return printSolution(dist);
    }
}
