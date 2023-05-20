package hw8;

/**
 *
 * @author Ertugrul Kasikci
 */
public interface DynamicGraph extends Graph{
 
    Vertex newVertex (String label, double weight);
    boolean addVertex (Vertex new_vertex);
    boolean addEdge (int vertexID1, int vertexID2, double weight);
    Edge removeEdge (int vertexID1, int vertexID2);
    Vertex removeVertex (int vertexID);
    Vertex removeVertex (String label);
    DynamicGraph filterVertices (String key, String filter);
    double[][] exportMatrix(); 
    public void printGraph();
}
