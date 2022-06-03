import java.util.*;

public abstract class AbsGraph<V extends Comparable<V>> implements IGraph<V> {

    protected SortedMap<V, SortedSet<V>> vertices;

    /**
     * Add a new vertex if none exists.
     */
    public void addVertex(V v) {
        if (!this.containsVertex(v)) {
            SortedSet<V> set = new TreeSet<>();
            this.vertices.put(v, set);
        }
    }

    /**
     * @return If the graph contains the vertex v.
     */
    public boolean containsVertex(V v) {
        return this.vertices.containsKey(v);


    }

    /**
     * @param u, v
     * @return If the edge (u,v) exists.
     */
    public boolean containsEdge(V u, V v) {
        Set<V> set = this.vertices.get(u);
        if (set != null) {
            return set.contains(v);
        }
        return false;
    }


    /**
     * Remove the vertex and its edges from the graph, and return its incidents. If
     * the vertex doesn't exit return null.
     */
    public Set<V> removeVertex(V v) {
        if (this.containsVertex(v)) {
            Set<V> result = this.vertices.get(v);
            this.vertices.remove(v);
            for (V k : this.vertices.keySet()) {
                if (this.containsEdge(k, v)) {
                    SortedSet<V> temp = this.vertices.get(k);
                    temp.remove(v);
                    this.vertices.put(k, temp);
                }
            }
            return result;
        }
        return null;
    }

    /**
     * @return the number of vertices
     */
    public int numOfVertices() {
        return this.vertices.size();
    }

    /**
     * @return the number of edges
     */
    public int numOfEdges() {
        int edges = 0;
        Set<V> keys = this.vertices.keySet();
        for (Object k : keys) {
            for (Object v : this.vertices.get(k)) {
                edges++;
            }
        }
        return edges;
    }

    /**
     * @return A string represents the graph. The string is as follows: First:
     * "DirectedGraph:\t" or "UndirectedGraph:\t". Then, the concatenation
     * of the vertices separated by one space. Every vertex is printed with a
     * comma separated list of its incident edges. The list is separated
     * from the vertex with a colon.
     * For example: the string "Directed
     * graph:\tA:{A,B} B:{} C:{A} D:{C,D}" represents a
     * directed graph where its vertices group is {A,B,C,D}, and the edges
     * group is {(A,A),(A,B),(C,A),(D,C),(D,D)}
     */
    public String toString() {
        String out = this.getGraphType() + "Graph" + ":\t";
        Set<V> keys = this.vertices.keySet();
        int cnt = 0;
        int key_cnt = 0;
        for (Object k : keys) {
            key_cnt++;
            out = out.concat(k.toString() + ":{");
            Set<V> values = this.vertices.get(k);
            for (Object v : values) {
                if (cnt < values.size() - 1) {
                    out = out.concat(v.toString() + ',');
                    cnt++;
                } else {
                    out = out.concat(v.toString());
                    cnt = 0;
                }
            }
            if (key_cnt < keys.size()) {
                out = out.concat("} ");
            } else {
                out = out.concat("}");
            }

        }
        return out;
    }


}


