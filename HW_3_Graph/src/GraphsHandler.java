import java.io.*;
import java.util.*;

public class GraphsHandler {

    public static void main(String[] args) throws IOException {
        int lineNum = 1;
        List<IGraph<String>> list = new ArrayList<>();
        SortedSet<IGraph<String>> sortedSet = new TreeSet<>(GraphsHandler::compare);

        File file = new File(args[0]);
        Writer errorFile = new FileWriter("errorsGraph.txt");
        Scanner s = new Scanner(file);
        while (s.hasNext()) {
            String line = s.nextLine();
            try {
                if (Objects.equals(line, "")) {
                    throw new HW3Exception("null");
                }
                list.add(0, GraphUtils.string2Graph(line));
                sortedSet.add(GraphUtils.string2Graph(line));
                lineNum++;
            } catch (HW3Exception e) {
                e.writeError(errorFile,lineNum,line);
            }
        }
        s.close();

        Writer graphListFile = new FileWriter("GraphsOutList.txt");
        Writer sortListFile = new FileWriter("GraphsSortOutList.txt");
        Writer sortSetFile = new FileWriter("GraphsSortOutSet.txt");

        int count = 0;
        for (IGraph<String> Graph : list) {
            graphListFile.append(Graph.toString());
            count++;
            if(count < list.size())
            graphListFile.append("\n");
        }

        count = 0;
        for (IGraph<String> Graph : sortedSet) {
            sortSetFile.append(Graph.toString());
            count++;
            if(count < sortedSet.size())
            sortSetFile.append("\n");
        }

        count = 0;
        list.sort(GraphsHandler::compare);
        for (IGraph<String> Graph : list) {
            sortListFile.append(Graph.toString());
            count++;
            if (count < list.size())
            sortListFile.append("\n");
        }

        graphListFile.flush();
        graphListFile.close();

        sortListFile.flush();
        sortListFile.close();

        sortSetFile.flush();
        sortSetFile.close();

        errorFile.flush();
        errorFile.close();
    }

    private static int compare(IGraph<String> o1, IGraph<String> o2) {
        if (o1.equals(o2))
            return 0;
        return o1.numOfVertices() > o2.numOfVertices() ? 1 : -1;
    }
}


