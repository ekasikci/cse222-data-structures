package hw8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Ertugrul Kasikci
 */
public class HW8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyGraph graph = new MyGraph(6, false);
        
        Q1Test(graph);
        Q2Test(graph);
        Q3Test(graph);
    }

    
    /** 
     * Prints the adjacency matrix representation of the graph which has vertices specified by adjacencyMatrix parameter
     * @param adjacencyMatrix adjacency matrix of the graph to be printed
     */
    static public void printAdjacencyMatrix(double[][] adjacencyMatrix)
    {
        System.out.print("    ");
        for (int i = 0; i < adjacencyMatrix.length; i++)
        { 
            System.out.print(" " + i + "    ");
        }
        System.out.println();
        
        for (int i = 0; i < adjacencyMatrix.length; i++) 
        {
            System.out.print(" " + i + "  ");
            for (int j = 0; j < adjacencyMatrix[i].length; j++) 
                System.out.printf("%-6s", adjacencyMatrix[i][j] + " ");
            System.out.println();
        }
        System.out.println("\n");
    }

    
    /** 
     * Implement breadth first search for the given graph 
     * @param graph graph to be searched by breadth first search
     */
    static public double BFSTraversel(MyGraph graph)
    {
        boolean[] isMarked = new boolean[graph.getNumV()];
        boolean[] isAdded = new boolean[graph.getNumV()];
        int vertex = 0;
        Queue<Integer> queue = new LinkedList<>();
        double totalDistance = 0; 

        queue.add(vertex);

        while(queue.size() > 0)
        {      
            vertex = queue.poll();

            if(!isMarked[vertex])
            {
                System.out.println(vertex + "    " + graph.getVertex(vertex).label + "   " + graph.getVertex(vertex).weight + "   " + graph.getVertex(vertex).userDefinedProperty);
                isMarked[vertex] = true;

                for(int j = 0; j < graph.adjacencyList.get(vertex).size(); j++)
                {
                    int smallestE = -1;
                    double smallestW = Double.POSITIVE_INFINITY;
                    for(int i = 0; i < graph.adjacencyList.get(vertex).size(); i++)
                    {
                        if(graph.adjacencyList.get(vertex).get(i).getWeight() < smallestW && !isAdded[graph.adjacencyList.get(vertex).get(i).getDest().index])
                        {
                            smallestW = graph.adjacencyList.get(vertex).get(i).getWeight();
                            smallestE = i;
                        }
                    }
                    if(smallestE != -1)
                    {
                        totalDistance += smallestW;
                        queue.add(graph.adjacencyList.get(vertex).get(smallestE).getDest().index);
                        isAdded[graph.adjacencyList.get(vertex).get(smallestE).getDest().index] = true;
                    }
                }
            }
        }
        return totalDistance;   
    } 

    /** 
     * Implements depth first search for the given graph 
     * @param graph graph to be searched by depth first search
     * @return Total distance traveled during DFS search
     */
    static public double DFSTraversel(MyGraph graph)
    {
        boolean[] isMarked = new boolean[graph.getNumV()];
        int index = 0;
        return DFSRecursive(graph, isMarked, index);
    }

    /** 
     * Helper recursive method of the DFSTraversel(MyGraph graph) method
     * @param graph graph to be searched by depth first search
     * @param isMarked keeps the list of the marked vertices
     * @param index index of the starting point vertex
     * @return Total distance traveled during DFS search
     */
    static private double DFSRecursive(MyGraph graph, boolean[] isMarked, int index)
    {
        System.out.println(index + "    " + graph.getVertex(index).label + "   " + graph.getVertex(index).weight + "   " + graph.getVertex(index).userDefinedProperty);
        isMarked[index] = true;

        double totalDistance = 0;

        for(int j = 0; j < graph.adjacencyList.get(index).size(); j++)
        {
            int smallestE = -1;
            double smallestW = Double.POSITIVE_INFINITY;
            for(int i = 0; i < graph.adjacencyList.get(index).size(); i++)
            {
                
                if(graph.adjacencyList.get(index).get(i).getWeight() < smallestW && !isMarked[graph.adjacencyList.get(index).get(i).getDest().index])
                {
                    smallestW = graph.adjacencyList.get(index).get(i).getWeight();
                    smallestE = i;
                }
            }
            if(smallestE != -1)
            {
                totalDistance +=  smallestW + DFSRecursive(graph, isMarked, graph.adjacencyList.get(index).get(smallestE).getDest().index);
            }
        }
        return totalDistance;
    }

    
    /** 
     * Test and shows the results of all the methods relating to question 1 
     * @param graph graph for to test the methods
     */
    public static void Q1Test(MyGraph graph)
    {
        System.out.println("Question 1 Test\n");
        ArrayList<HashMap<String ,String>> userProperties = new ArrayList<HashMap<String ,String>>();
        
        for (int i = 0; i < 10; i++)
        {
            userProperties.add(new HashMap<String ,String>());
            
            userProperties.get(i).put("Test Vertex 1", "1");
            if(i % 3 == 0)
                userProperties.get(i).put("Color", "Blue");
                else if (i % 3 == 1)
                userProperties.get(i).put("Color", "Red");
                else
                userProperties.get(i).put("Color", "Black");
                
                if(i%4 == 0)
                userProperties.get(i).put("Boosting", i + "");
                
                graph.addVertex(new Graph.Vertex("label" + i, i, userProperties.get(i)));
            }
        
            
        graph.addEdge(0, 5 , 9);
        graph.addEdge(0, 4 , 8);
        graph.addEdge(4, 8 , 9);
        graph.addEdge(0, 8 , 18);
        graph.addEdge(6, 4 , 18); 
        graph.addEdge(5, 7 , 9);
        graph.addEdge(2, 1, 4);
        graph.addEdge(1, 3, 2);
        graph.addEdge(1, 4, 7);

        graph.addVertex(graph.newVertex("label10", 3));
        graph.addVertex(graph.newVertex("to be removed", 3));
        

        System.out.println("Number of vertices: " + graph.getNumV());
        System.out.println("Is graph directed: " + graph.isDirected());
        System.out.println("isEdge method from vertex 6 to vertex 4: " + graph.isEdge(6, 4));
        System.out.println("isEdge method for an unexist edge: " + graph.isEdge(2, 8));
        System.out.println("getEdge method from vertex 4 to vertex 8: " + graph.getEdge(4, 8));
        System.out.println("getEdge method for an unexist edge: " + graph.getEdge(1, 9));
        System.out.println("removeEdge method from vertex 5 to vertex 7: " + graph.removeEdge(5, 7));
        System.out.println("removeEdge method for an unexist vertex: " + graph.removeEdge(8, 3));
        System.out.println("removeVertex method for vertex 10 by calling it with ID: " + graph.removeVertex(10));
        System.out.println("removeVertex method for an unexist vertex by calling it with ID: " +  graph.removeVertex(50));
        System.out.println("removeVertex method for vertex 10 by calling it with label: " + graph.removeVertex ("to be removed"));
        System.out.println("removeVertex method for unexist vertex by calling it with label: " + graph.removeVertex ("there is no such label"));

        System.out.println("\nprintGraph method:\n");
        graph.printGraph();
        
        System.out.println("Adjacency Matrix representation of the graph:\n");
        double [][] adjacencyMatrix = graph.exportMatrix();
        printAdjacencyMatrix(adjacencyMatrix);
        
        MyGraph subGraph = graph.filterVertices("Color", "Black");
        System.out.println("Printing of the filtered graph with 'Color' key and 'Black' value\n");
        subGraph.printGraph();

        MyGraph undirectedGraph = new MyGraph(5, false);
        MyGraph directedGraph = new MyGraph(5, true);
        
        undirectedGraph.addVertex(new Graph.Vertex("label1", 1));
        undirectedGraph.addVertex(new Graph.Vertex("label2", 6));
        undirectedGraph.addVertex(new Graph.Vertex("label3", 4));
        undirectedGraph.addVertex(new Graph.Vertex("label4", 3));
        undirectedGraph.addVertex(new Graph.Vertex("label5", 7));

        directedGraph.addVertex(new Graph.Vertex("label1", 1));
        directedGraph.addVertex(new Graph.Vertex("label2", 6));
        directedGraph.addVertex(new Graph.Vertex("label3", 4));
        directedGraph.addVertex(new Graph.Vertex("label4", 3));
        directedGraph.addVertex(new Graph.Vertex("label5", 7));
        
        undirectedGraph.addEdge(0, 1 , 9);
        undirectedGraph.addEdge(2, 3 , 5);

        directedGraph.addEdge(0, 1 , 9);
        directedGraph.addEdge(2, 3 , 5);
        
        System.out.println("Printing an directed graph\n");
        directedGraph.printGraph();

        System.out.println("Printing an undirected graph\n");
        undirectedGraph.printGraph();
    }

    
    /** 
     * Test and shows the results of all the methods relating to question 2
     * @param graph graph for to test the methods
     */
    public static void Q2Test(MyGraph graph)
    {
        System.out.println("Question 2 Test\n");
        double BFSDistance, DFCDistance, difference;
        System.out.println("DFS\n");
        DFCDistance = DFSTraversel(graph);
        System.out.println("BFS\n");
        BFSDistance = BFSTraversel(graph);
        difference =  BFSDistance - DFCDistance;
        System.out.println("\n\nBFS total distance = " + BFSDistance + " ,DFS total distance = " + DFCDistance + " ,distance difference = " + difference + "\n\n");
    }

    
    /** 
     * Test and shows the results of all the methods relating to question 3
     * @param graph graph for to test the methods
     */
    public static void Q3Test(MyGraph graph)
    {
        System.out.println("Question 3 Test\n");
        System.out.println("Dijkstra's Algorithm for vertex 0\n");
        DijkstrasAlgorithm(graph, 0);
    }
    
    
    /** 
     * Implements Dijkstra's Algorithm (calculates the shortest paths from the given vertex to all other vertices in the graph)
     * @param graph graph to be used when implementing Dijkstra's Algorithm
     * @param vertex vertex to be used when implementing Dijkstra's Algorithm
     */
    static public void DijkstrasAlgorithm(MyGraph graph, int vertex)
    {
        ArrayList<Integer> S = new ArrayList<Integer>();
        ArrayList<Integer> VS = new ArrayList<Integer> ();
        double[] d = new double[graph.getNumV()];
        int[] p = new int[graph.getNumV()];

        for (int i = 0; i < graph.getNumV(); i++)
                VS.add(i);
        
        for (int i = 0; i < VS.size(); i++) 
        {
            p[i] = vertex;

            try 
            {
                d[i] = graph.getEdge(vertex, i).getWeight();
            } catch (NullPointerException e) {
                if(vertex == i)
                d[i] = 0;
                else
                    d[i] = Double.POSITIVE_INFINITY;
            }
            
        }

        while (VS.size() != 0) 
        {
            int minV = -1;
            double minD = Double.POSITIVE_INFINITY;
            for (int i = 0; i < VS.size(); i++) 
            {
                if (i != vertex && d[i] < minD) {
                    minD = d[i];
                    minV = i;
                }
            }
            
            if (minV == -1)
                break;

            for (int i = 0; i < VS.size(); i++) 
            {
                if (graph.isEdge(minV, i)) 
                {
                    double weight = graph.getEdge(minV, i).getWeight();
                    double newD = d[minV] + weight;

                    if(graph.getVertex(minV).userDefinedProperty.containsKey("Boosting"))
                        newD -= Double.parseDouble(graph.getVertex(minV).userDefinedProperty.get("Boosting"));

                    if (newD < d[i]) 
                    {
                        d[i] = newD;
                        p[i] = minV;
                    }
                }
            }
            VS.remove(minV);
            S.add(minV);
        }

        for (int i = 0; i < graph.getNumV(); i++) {
            System.out.println("Vertex - " + i + " : Predecessor - " + p[i] + " : Distance - " + d[i]);

        }
    }
}
