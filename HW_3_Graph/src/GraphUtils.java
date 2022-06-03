import java.io.File;
import java.util.Objects;
import java.util.Scanner;

public class GraphUtils {
    private static double PRECISION = 1.0e-2;

    /**
     * @param d : double
     * @return String represents d with 2 places after the decimal point.
     */
    public static String formatDouble(double d) {
        String res = String.format("%.2f", d);
        if (res.equals("-0.00"))
            res = "0.00";
        return res;
    }

    public static boolean areEqual(double d1, double d2) {
        return Math.abs(d1 - d2) < PRECISION;
    }


    public static IGraph<String> string2Graph(String string) throws HW3Exception {
        IGraph<String> graph;
        Scanner s = new Scanner(string);
        s.useDelimiter("\\t");
        String graphType = s.next();

        if (Objects.equals(graphType, "DirectedGraph:")) {
            graph = new DirectedGraph<String>();
        } else if (Objects.equals(graphType, "UndirectedGraph:")) {
            graph = new UndirectedGraph<String>();
        } else {
            throw new HW3Exception("The graph type is not valid");
        }

        s.useDelimiter("[ \t:]");
        while (s.hasNext()) {
            String vertex = s.next();
            graph.addVertex(vertex);
            String edge = s.next();
            String[] edges = edge.split("");

            if (!Objects.equals(edges[0], "{")){
                throw new HW3Exception("Exception in scanning the graph string");
            }
            if (!Objects.equals(edges[edges.length-1], "}")){
                throw new HW3Exception("Exception in scanning the graph string");
            }

            String temp = "";
            for (int i = 1; i < edges.length - 1; i++) {
                if (!Objects.equals(edges[i], ",")) {
                    temp += (edges[i]);
                } else {
                    graph.addEdge(vertex, temp);
                    temp = "";
                }
            }
            if (!temp.equals("")) {
                graph.addEdge(vertex, temp);
            }
        }
        s.close();
        return graph;
    }
}
