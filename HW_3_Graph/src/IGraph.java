import java.util.Set;

public interface IGraph<V extends Comparable<V>> {

	/**
	 * Add a new vertex if none exists.
	 */
	public void addVertex(V v);

	/**
	 * Add a new edge if none exists between the two vertices. If the vertices u or
	 * v do not exist, add them to the graph.
	 */
	public void addEdge(V u, V v);

	/**
	 * @return If the graph contains the vertex v.
	 */
	public boolean containsVertex(V v);

	/**
	 * @param u, v
	 * @return If the the edge (u,v) exists.
	 */
	public boolean containsEdge(V u, V v);

	/**
	 * Remove the vertex and its edges from the graph, and return its incidents. If
	 * the vertex dosn't exit return null.
	 */
	public Set<V> removeVertex(V v);

	/**
	 * @return Remove the edge (u,v) if it exists, and return True. If this edge
	 *         does not exist return False.
	 */
	public boolean removeEdge(V u, V v);
	
	
	/**
	 * @return the type of the graph "Directed" or "Undirected".
	 */
	public String getGraphType();

	/**
	 * @return the number of vertices
	 */
	public int numOfVertices();
	
	/**
	 * @return the number of edges
	 */	
	public int numOfEdges();

	/**
	 * @return A string represents the graph. The string is as follows: First:
	 *         "DirectedGraph:\t" or "UndirectedGraph:\t". Then, the concatenation
	 *         of the vertices separated by one space. Every vertex is printed with a
	 *         comma separated list of its incident edges. The list is separated
	 *         from the vertex with a colon.
	 *         For example: the string "Directed
	 *         graph:\tA:{A,B} B:{} C:{A} D:{C,D}" represents a
	 *         directed graph where its vertices group is {A,B,C,D}, and the edges
	 *         group is {(A,A),(A,B),(C,A),(D,C),(D,D)}
	 */
	public String toString();

}