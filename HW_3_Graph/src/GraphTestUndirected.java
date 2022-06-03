import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GraphTestUndirected extends GraphTestAbstract {

	@Override
	public void setUp() {
		graph = new UndirectedGraph<String>();
		friendsGraph = new UndirectedGraph<Person>();
		type = "UndirectedGraph:\t";
	}
	
	@Test
	public void testRemoveEdge() {
		super.testRemoveEdge();
		
		assertEquals(type + "A:{A,B} B:{A,C} C:{B,D} D:{C,D}", graph.toString());
		assertTrue(graph.removeEdge("C", "B"));
		assertEquals(type + "A:{A,B} B:{A} C:{D} D:{C,D}", graph.toString());
		assertFalse(graph.removeEdge("A", "E"));
		assertEquals(type + "A:{A,B} B:{A} C:{D} D:{C,D}", graph.toString());
		assertFalse(graph.removeEdge("E", "A"));
		assertFalse(graph.removeEdge("B", "C"));
		assertEquals(type + "A:{A,B} B:{A} C:{D} D:{C,D}", graph.toString());
		
	}
	
	@Test
	public void testAreAdjacent() {
		super.testAreAdjacent();
		assertTrue(graph.containsEdge("C", "B"));
	}
	
	@Test
	public void testSizeGraph()
	{
		super.testSizeGraph();
		assertEquals(4,graph.numOfVertices());
		assertEquals(8,graph.numOfEdges());
	} 
	
	@Test
	public void testPutVVE() {
		super.testPutVVE();
		graph.addEdge("A", "B");
		assertEquals(type + "A:{B} B:{A} C:{} D:{}", graph.toString());
		graph.addEdge("B", "C");
		graph.addEdge("C", "D");
		assertEquals(type + "A:{B} B:{A,C} C:{B,D} D:{C}", graph.toString());
	}
	
	@Test
	public void testFriendship() {
		super.testFriendship();
		assertEquals(type
				+ "Person [012960449 M S]:{Person [317919249 A S]} Person [317919249 A S]:{Person [012960449 M S]}",
				friendsGraph.toString());
	}

}