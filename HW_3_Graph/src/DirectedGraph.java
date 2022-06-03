
import java.util.*;


public class DirectedGraph<V extends Comparable<V>> extends AbsGraph<V> implements IGraph<V> {

    public DirectedGraph() {
        super();
        this.vertices = new TreeMap<>();
    }

    /**
     * Add a new edge if none exists between the two vertices. If the vertices u or
     * v do not exist, add them to the graph.
     */
    public void addEdge(V u, V v) {
        if (!this.containsVertex(u)) this.addVertex(u);
        if (!this.containsVertex(v)) this.addVertex(v);
        this.vertices.get(u).add(v);

    }

    /**
     * @return Remove the edge (u,v) if it exists, and return True. If this edge
     *         does not exist return False.
     */
    public boolean removeEdge(V u, V v) {
        if (this.containsEdge(u, v)) {
            SortedSet<V> values = this.vertices.get(u);
            values.remove(v);
            this.vertices.put(u, values);
            return true;
        }
        return false;
    }


    /**
     * @return the type of the graph "Directed" or "Undirected".
     */
    public String getGraphType() {
        return "Directed";
    }




}
