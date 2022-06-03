
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

public abstract class GraphTestAbstract {

	protected IGraph<String> graph;
	protected IGraph<Person> friendsGraph;
	protected String type;

	@Before
	public abstract void setUp();

	@Test
	public void testGraph() {
		assertEquals(type, graph.toString());
	}

	@Test
	public void testAddVertex() {
		graph.addVertex("A");
		assertEquals(type + "A:{}", graph.toString());
		graph.addVertex("B");
		assertEquals(type + "A:{} B:{}", graph.toString());
	}

	@Test
	public void testRemoveNoEdges() {
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.removeVertex("C");
		assertEquals(type + "A:{} B:{} D:{}", graph.toString());
	}

	@Test
	public void testPutVVE() {
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		assertEquals(type + "A:{} B:{} C:{} D:{}", graph.toString());
	}

	public void updateGraph() {
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addEdge("A", "A");
		graph.addEdge("A", "B");
		graph.addEdge("B", "A");
		graph.addEdge("B", "C");
		graph.addEdge("C", "D");
		graph.addEdge("D", "C");
		graph.addEdge("D", "D");
	}

	@Test
	public void testFriendship() {
		Person p1 = new Person("012960449", "M", "S");
		Person p2 = new Person("317919249", "A", "S");
		friendsGraph.addVertex(p1);
		friendsGraph.addVertex(p2);
		friendsGraph.addEdge(p1, p2);

	}

	@Test
	public void testGet() {
		updateGraph();
		graph.addEdge("A", "B");
		assertFalse(graph.containsEdge("A", "C"));
		assertTrue(graph.containsEdge("A", "B"));
	}

	@Test
	public void testSizeGraph()
	{
		updateGraph();
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addEdge("D", "C");
	}
	
	@Test
	public void testAreAdjacent() {
		updateGraph();
		assertTrue(graph.containsEdge("A", "B"));
		assertTrue(graph.containsEdge("B", "C"));
		assertTrue(graph.containsEdge("C", "D"));
		assertTrue(graph.containsEdge("D", "C"));
		assertFalse(graph.containsEdge("A", "C"));
		assertFalse(graph.containsEdge("E", "C"));
		assertFalse(graph.containsEdge("A", "E"));
	}

	@Test
	public void testRemoveEdge() {
		updateGraph();
	}

	@Test
	public void testContainsVertex() {
		updateGraph();

		assertTrue(graph.containsVertex("A"));
		assertTrue(graph.containsVertex("B"));
		assertTrue(graph.containsVertex("C"));
		assertTrue(graph.containsVertex("D"));
		assertFalse(graph.containsVertex("E"));
		assertFalse(graph.containsVertex("F"));

		Person p1 = new Person("012960449", "M", "S");
		Person p2 = new Person("317919249", "A", "S");
		friendsGraph.addVertex(p1);
		friendsGraph.addVertex(p2);
	
		assertTrue(friendsGraph.containsVertex(p1));
		assertTrue(friendsGraph.containsVertex(new Person("317919249", "A", "S")));
		assertFalse(friendsGraph.containsVertex(new Person("327919249", "A", "S")));
		
		friendsGraph.addVertex(p2);
		friendsGraph.addVertex(p1);
		friendsGraph.addVertex(new Person("317919249", "A", "S"));
		assertEquals(2, friendsGraph.numOfVertices());
		
		
	}

}