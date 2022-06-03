
import java.util.SortedSet;
import java.util.TreeMap;

public class UndirectedGraph<V extends Comparable<V>> extends AbsGraph<V> implements IGraph<V> {

    public UndirectedGraph() {
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
        this.vertices.get(v).add(u);
    }

    /**
     * @return Remove the edge (u,v) if it exists, and return True. If this edge
     *         does not exist return False.
     */
    public boolean removeEdge(V u, V v) {
        if (this.containsEdge(u, v) && this.containsEdge(v, u)) {

            SortedSet<V> values = this.vertices.get(u);
            values.remove(v);
            this.vertices.put(u, values);

            SortedSet<V> values2 = this.vertices.get(v);
            values2.remove(u);
            this.vertices.put(v, values2);

            return true;
        }
        return false;
    }

    /**
     * @return the type of the graph "Directed" or "Undirected".
     */
    public String getGraphType() {
        return "Undirected";
    }

}
