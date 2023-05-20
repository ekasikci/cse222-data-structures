package hw8;

import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Ertugrul Kasikci
 */
public interface Graph {
    
    int getNumV();
    boolean isDirected();
    void insert(Edge edge);
    boolean isEdge(int source, int dest);
    Edge getEdge(int source, int dest);
    Iterator<Edge> edgeIterator(int source);
    
    public class Edge
    {
        public Edge(Vertex source, Vertex dest){  this.source = source; this.dest = dest; weight = 1.0;   }
        public Edge(Vertex source, Vertex dest, double weight){  this.source = source; this.dest = dest; this.weight = weight;  }
                
                
        public boolean equals(Object obj)
        {
            if (obj instanceof Edge) 
            {
                Edge edge = (Edge) obj;
                return (source == edge.source && dest == edge.dest && weight == edge.weight);
            }
            return false;
        }
        public Vertex getDest(){ return dest; }
        public Vertex getSource(){ return source; }
        public double getWeight(){ return weight; }
        public int hashCode(){ return (source.index << 16) ^ dest.index; }
        public String toString()
        {
            StringBuffer sb = new StringBuffer("[(");
            sb.append(source.index);
            sb.append(", ");
            sb.append(dest.index);
            sb.append("): ");
            sb.append(weight);
            sb.append("]");
            return sb.toString();
        }
                
        private Vertex dest;
        private Vertex source; 
        private double weight;
    }
    
    public class Vertex
    {
        Vertex(String label, double weight, int index){ this.label = label; this.weight = weight; this.index = index; }
        Vertex(String label, double weight, int index, Map<String, String> userDefinedProperty){ this.label = label; this.weight = weight; this.index = index; 
        this.userDefinedProperty = userDefinedProperty; }
        Vertex(String label, double weight){ this.label = label; this.weight = weight; }
        Vertex(String label, double weight, Map<String, String> userDefinedProperty){ this.label = label; this.weight = weight; this.userDefinedProperty = userDefinedProperty;}

        public String printProperty()
        {
            StringBuilder str = new StringBuilder();

            for (Map.Entry<String, String> me :
            userDefinedProperty.entrySet()) 
            {
                str.append(me.getKey() + ":");
                str.append(me.getValue());
            }
            return str.toString();
        }

        public String toString()
        {
            StringBuffer sb = new StringBuffer("Index: ");
            sb.append(index);
            sb.append(" - Weight: ");
            sb.append(weight);
            sb.append(" - Label");
            sb.append(label);
            sb.append(" - User Defined Property: ");
            sb.append(userDefinedProperty);
            return sb.toString();
        }
        
        public int index;
        public double weight;
        public String label;
        public Map<String, String> userDefinedProperty;
    }
}
