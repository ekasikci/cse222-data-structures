package hw8;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Ertugrul Kasikci
 */
public class MyGraph implements DynamicGraph{
    
    public MyGraph(int numV, boolean directed)
    {
        adjacencyList = new ArrayList<ArrayList<Edge>>(numV);
        vertices = new ArrayList<Vertex>(numV);
        this.directed = directed;
    }

    public MyGraph(ArrayList<ArrayList<Edge>> adjacencyList, ArrayList<Vertex> vertices, boolean directed)
    {
        this.adjacencyList = adjacencyList;
        this.vertices = vertices;
        this.directed = directed;
    }
    
    
    /** 
     * Checks if there is an edge with given parameters
     * @param source index of the source vertex
     * @param dest index of the destination vertex
     * @return true if there is an edge with the given parameters, otherwise false
     */
    public boolean isEdge(int source, int dest) 
    {
        if(source < 0 || dest < 0)
            return false;

        for(int i = 0; i < adjacencyList.get(source).size(); i++)
        {
            if(adjacencyList.get(source).get(i).getDest().index == dest)
                return true;
        }    
        return false;
    }
    
    
    /** 
     * Inserts the edge according to its source and destination vertices
     * @param edge edge to be inserted
     */
    public void insert(Edge edge)
    {

        if(!(edge.getSource().index < adjacencyList.size()) && edge.getDest().index < adjacencyList.size())
            addVertex(edge.getSource());  
        else if(edge.getSource().index < adjacencyList.size() && !(edge.getDest().index < adjacencyList.size()))
            addVertex(edge.getDest());             
        else if(!(edge.getSource().index < adjacencyList.size()) && !(edge.getDest().index < adjacencyList.size()))
        {
            addVertex(edge.getSource());
            addVertex(edge.getDest());
        }      
        adjacencyList.get(edge.getSource().index).add(edge);

        if(!directed) // adds the edge for the dest vertex if the graph is not directed. dest and source vertices is switched for the edge.
            adjacencyList.get(edge.getDest().index).add(new Edge(edge.getDest(), edge.getSource(), edge.getWeight())); 
    }
    
    
    /** 
     * Returns an iterator for the edges of the vertex which is specified by the given parameter
     * @param source index of the vertex
     * @return Iterator<Edge>
     */
    public Iterator<Edge> edgeIterator(int source)
    {
        return adjacencyList.get(source).iterator();
    }
    
    
    /** 
     * Returns the which has vertices specified by the given parameters
     * @param source index of the source vertex
     * @param dest index of the destination vertex
     * @return Specified Edge if it is exist, otherwise null 
     */
    public Edge getEdge(int source, int dest)
    {
        if(source < 0 || dest < 0)
            return null;
        if(adjacencyList.size() < source)
            return null;

        for(int i = 0; i < adjacencyList.get(source).size(); i++)
        {
            if(adjacencyList.get(source).get(i).getDest().index == dest)
                return adjacencyList.get(source).get(i);
        }    
        return null;
    } 

    
    /** 
     * @return Number of vertives in the graph
     */
    @Override
    public int getNumV() {
        return vertices.size();
    }

    
    /** 
     * @return true if the grapf is directed, otherwise false
     */
    @Override
    public boolean isDirected() {
        return directed;
    }

    
    /** 
     * Creates and returns a new vertex by given parameters
     * @param label label of the new vertex
     * @param weight weight of the new vertex
     * @return Created Vertex
     */
    @Override
    public Vertex newVertex (String label, double weight) {
        return new Vertex(label, weight, adjacencyList.size());
    }

    
    /** 
     * Adds the given vertex to the graph
     * @param new_vertex vertex to be added
     * @return true, as long as there is enough memory
     */
    @Override
    public boolean addVertex(Vertex new_vertex) {
        adjacencyList.add(new_vertex.index, new ArrayList<Edge>());
        vertices.add(new Vertex(new_vertex.label, new_vertex.weight, vertices.size(), new_vertex.userDefinedProperty));
        return true;
    }

    
    /** 
     * Add the edge which has properties specified by the given parameters to the graph
     * @param vertexID1 index of the source vertex of the edge to be added
     * @param vertexID2 index of the destination vertex of the edge to be added
     * @param weight weight of the edge to be added
     * @return true, as long as there is enough memory
     */
    @Override
    public boolean addEdge(int vertexID1, int vertexID2, double weight) {
        if(adjacencyList.size() < vertexID1 || adjacencyList.size() < vertexID2)
            return false;

        if(!directed)
            adjacencyList.get(vertexID2).add(new Edge(vertices.get(vertexID2), vertices.get(vertexID1), weight));

        return adjacencyList.get(vertexID1).add(new Edge(vertices.get(vertexID1), vertices.get(vertexID2), weight));      
    }

    
    /** 
     * Return the vertex which has the same ID with index parameter
     * @param index ID of the vertex to be returned
     * @return Specified Vertex if it exist, otherwise null
     */
    public Vertex getVertex(int index)
    {
        return vertices.get(index);
    }

    
    /** 
     * Removes the edge which has properties specified by the given parameters from the graph
     * @param vertexID1 index of the source vertex of the edge to be removed
     * @param vertexID2 index of the destination vertex of the edge to be removed
     * @return Removed Edge if it exist, otherwise null
     */
    @Override
    public Edge removeEdge(int vertexID1, int vertexID2) {

        if(adjacencyList.size() < vertexID1 || adjacencyList.size() < vertexID2)
            return null;

        if(!directed)
        {
            for(int i = 0; i < adjacencyList.get(vertexID2).size(); i++)
            {
                if(adjacencyList.get(vertexID2).get(i).getDest().index == vertexID1)
                adjacencyList.get(vertexID2).remove(i);
            }
        }

        for(int i = 0; i < adjacencyList.get(vertexID1).size(); i++)
        {
            if(adjacencyList.get(vertexID1).get(i).getDest().index == vertexID2)
                return adjacencyList.get(vertexID1).remove(i);
        }
        return null;
    }

    
    /**
     * Return the vertex which has the same ID with vertexID parameter
     * @param vertexID ID of the vertex to be removed
     * @return Removed Vertex if it exist, otherwise null
     */
    @Override
    public Vertex removeVertex(int vertexID) {
        if(vertexID > vertices.size())
            return null;

        for(int i = vertexID; i < vertices.size(); i++)
            vertices.get(i).index = i;
            
        adjacencyList.remove(vertexID);
        return vertices.remove(vertexID);
    }

    
    /** 
     * Return the vertex which has the same label with label parameter
     * @param label label of the vertex to be removed
     * @return Removed Vertex if it exist, otherwise null
     */
    @Override
    public Vertex removeVertex(String label) {
        int removeIndex = -1;
        for(int i = 0; i < vertices.size(); i++)
        {
            if(vertices.get(i).label == label)
            {
                    removeIndex = i;
                    break;
            }
                
        }
        
        if(removeIndex != -1)
        {
            for(int i = removeIndex; i < vertices.size(); i++)
                vertices.get(i).index = i;
            return removeVertex(removeIndex);
        }
        return null;
    }

    
    /** 
     * Returns a new graph which its vertices has key and filer parameters. Thish graph is filtered from the graph which calls this method
     * @param key key parameter
     * @param filter valeue parameter
     * @return new graph from the filtered from the calling graph which its vertices has key and filter parameters.
     */
    @Override
    public MyGraph filterVertices(String key, String filter) {

        ArrayList<Vertex> subVertices = new ArrayList<Vertex>();
        ArrayList<ArrayList<Edge>> subAdjacencyList = new ArrayList<ArrayList<Edge>>();

        for(int i = 0; i < vertices.size(); i++)
        {
            try 
            {
                if(vertices.get(i).userDefinedProperty.get(key) == filter)
                {
                    subVertices.add(vertices.get(i));
                    subAdjacencyList.add(new ArrayList<Edge>());

                    for(int j = 0; j < adjacencyList.get(i).size(); j++)
                    {
                        if(adjacencyList.get(i).get(j).getDest().userDefinedProperty.get(key) == filter)
                            subAdjacencyList.get(subAdjacencyList.size()-1).add(adjacencyList.get(i).get(j));
                    } 
                }
                
            } catch (NullPointerException e) {

            }
            
        }
        return new MyGraph(subAdjacencyList, subVertices, directed);
    }

    
    /** 
     * Converts adjacency list graph to a adjacency matrix graph and returns it
     * @return Adjacency matrix representation of the graph
     */
    @Override
    public double[][] exportMatrix() {
        double[][] adjacencyMatrix = new double[vertices.size()][vertices.size()];

        for(int i = 0; i < adjacencyList.size(); i++)
        {
            for (int j = 0; j < adjacencyList.get(i).size(); j++) 
                adjacencyMatrix[i][adjacencyList.get(i).get(j).getDest().index] = adjacencyList.get(i).get(j).getWeight();
        }
        return adjacencyMatrix;
    }

    /**
     * Prints the graph
     */
    @Override
    public void printGraph() {
        for(int i = 0; i < adjacencyList.size(); i++)
        {
            System.out.print("[Vertex "+ vertices.get(i).index + "|" + vertices.get(i).weight + "]");
            for (int j = 0; j < adjacencyList.get(i).size(); j++)
                System.out.print(" -> [Vertex "+ adjacencyList.get(i).get(j).getDest().index +  "|" + adjacencyList.get(i).get(j).getDest().weight + "]");

            System.out.println();
        }
        System.out.println("\n");
    }

    /**
     * Prints all vertices of the graph
     */
    public void printVertices()
    {
        for (int i = 0; i < vertices.size(); i++) {
            System.out.println(vertices.get(i));
        } 
    } 

    public ArrayList<ArrayList<Edge>> adjacencyList;
    private ArrayList<Vertex> vertices;
    private boolean directed;
}
